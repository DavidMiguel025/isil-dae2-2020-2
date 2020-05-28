package pe.isil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.model.Loan;
import pe.isil.model.Payment;
import pe.isil.service.LoanService;
import pe.isil.service.PaymentService;

@Controller
public class LoanController {

    private LoanService loanService;
    private PaymentService paymentService;

    public LoanController(LoanService loanService, PaymentService paymentService) {
        this.loanService = loanService;
        this.paymentService = paymentService;
    }

    @GetMapping("/loans")
    public String loanList(Model model){
        model.addAttribute("loans", loanService.findAll());
        return "loan-list";
    }

    @GetMapping("/loans/add")
    public String loanAdd(Model model){
        model.addAttribute("loan", new Loan());
        return "loan-add";
    }

    @PostMapping("/loans/save")
    public String loanSave(Loan loan){
        loanService.create(loan);
        return "redirect:/loans";
    }

    @GetMapping("/loans/edit/{loanNumber}")
    public String loanEdit(@PathVariable Long loanNumber, Model model){
        Loan currentLoan = loanService.findById(loanNumber);
        if (currentLoan != null){
            model.addAttribute("loan", currentLoan);
        }
        return "loan-edit";
    }

    @PostMapping("/loans/update/{loanNumber}")
    public String loanUpdate(@PathVariable String loanNumber, Loan loan){
        loanService.update(loan);
        return "redirect:/loans";
    }

    @GetMapping("/loans/delete/{loanNumber}")
    public String loanDelete(@PathVariable Long loanNumber){
        Loan currentLoan = loanService.findById(loanNumber);
        if (currentLoan != null){
            loanService.delete(currentLoan);
        }
        return "redirect:/loans";
    }

    // loans + payments

    @GetMapping("/loans/{loanNumber}/payments")
    public String paymentList(Model model, @PathVariable Long loanNumber){
        model.addAttribute("loanNumber", loanNumber);
        model.addAttribute("payments", paymentService.findByLoan(loanNumber));
        return "payment-list";
    }

    @GetMapping("/loans/{loanNumber}/payments/add")
    public String paymentAdd(Model model, @PathVariable String loanNumber){
        model.addAttribute("loanNumber", loanNumber);
        model.addAttribute("payment", new Payment());
        return "payment-add";
    }

    @PostMapping("/loans/{loanNumber}/payments/save")
    public String paymentSave(Payment payment, @PathVariable Long loanNumber){
        Loan currentLoan = loanService.findById(loanNumber);
        if(currentLoan != null){
            payment.setLoan(currentLoan);
            paymentService.create(payment);
        }
        return "redirect:/loans/"+loanNumber+"/payments";
    }

    @GetMapping("/loans/{loanNumber}/payments/edit/{paymentId}")
    public String paymentEdit(@PathVariable Long paymentId, Model model, @PathVariable Long loanNumber){
        Loan currentLoan = loanService.findById(loanNumber);
        if(currentLoan != null){
            Payment currentPayment = paymentService.findById(paymentId);
            if (currentPayment != null){
                model.addAttribute("loanNumber", loanNumber);
                model.addAttribute("paymentId", paymentId);
                model.addAttribute("payment", currentPayment);
            }
        }

        return "payment-edit";
    }

    @PostMapping("/loans/{loanNumber}/payments/update/{paymentId}")
    public String paymentUpdate(@PathVariable Long paymentId, Payment payment, @PathVariable Long loanNumber){
        Loan currentLoan = loanService.findById(loanNumber);
        if(currentLoan != null){
            payment.setLoan(currentLoan);
            paymentService.update(payment);
        }

        return "redirect:/loans/"+loanNumber+"/payments";
    }

    @GetMapping("/loans/{loanNumber}/payments/delete/{paymentId}")
    public String paymentDelete(@PathVariable Long paymentId, @PathVariable Long loanNumber){
        Loan currentLoan = loanService.findById(loanNumber);
        if(currentLoan != null){
            Payment currentPayment = paymentService.findById(paymentId);
            if (currentPayment != null){
                paymentService.delete(currentPayment);
            }
        }

        return "redirect:/payments";
    }


}
