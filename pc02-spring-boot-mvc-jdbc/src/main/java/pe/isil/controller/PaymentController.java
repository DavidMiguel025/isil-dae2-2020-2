//package pe.isil.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import pe.isil.model.Payment;
//import pe.isil.service.PaymentService;
//
//@Controller
//public class PaymentController {
//
//    private PaymentService paymentService;
//
//    public PaymentController(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
//
//    @GetMapping("/payments")
//    public String loanList(Model model){
//        model.addAttribute("payments", paymentService.findAll());
//        return "payment-list";
//    }
//
//    @GetMapping("/payments/add")
//    public String loanAdd(Model model){
//        model.addAttribute("payment", new Payment());
//        return "payment-add";
//    }
//
//    @PostMapping("/payments/save")
//    public String loanSave(Payment payment){
//        paymentService.create(payment);
//        return "redirect:/payments";
//    }
//
//    @GetMapping("/payments/edit/{paymentId}")
//    public String loanEdit(@PathVariable Long paymentId, Model model){
//        Payment currentLoan = paymentService.findById(paymentId);
//        if (currentLoan != null){
//            model.addAttribute("payment", currentLoan);
//        }
//        return "payment-edit";
//    }
//
//    @PostMapping("/payments/update/{paymentId}")
//    public String loanUpdate(@PathVariable String paymentId, Payment payment){
//        paymentService.update(payment);
//        return "redirect:/payments";
//    }
//
//    @GetMapping("/payments/delete/{paymentId}")
//    public String loanDelete(@PathVariable Long paymentId){
//        Payment currentLoan = paymentService.findById(paymentId);
//        if (currentLoan != null){
//            paymentService.delete(currentLoan);
//        }
//        return "redirect:/payments";
//    }
//
//}
