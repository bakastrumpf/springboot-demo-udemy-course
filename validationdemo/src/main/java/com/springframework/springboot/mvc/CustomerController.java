package com.springframework.springboot.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    // to not allow empty string as last name
    // add init binder to convert trim input strings
    // resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showForm(Model theModel) {

        theModel.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer theCustomer,
            BindingResult theBindingResult) {

        // debugging trick:
        System.out.println("Last name: |" + theCustomer.getLastName() + "|");
        System.out.println("Binding results: |" + theBindingResult.toString() + "|");
        System.out.println("\n\n");

        /*
        renders the following:

        Last name: |null|
        Binding results: |org.springframework.validation.BeanPropertyBindingResult: 3 errors
        Field error in object 'customer' on field 'freePasses': rejected value [hgj9652]; codes [typeMismatch.customer.freePasses,typeMismatch.freePasses,typeMismatch.java.lang.Integer,typeMismatch]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [customer.freePasses,freePasses]; arguments []; default message [freePasses]]; default message [Failed to convert property value of type 'java.lang.String' to required type 'java.lang.Integer' for property 'freePasses'; For input string: "hgj9652"]
        Field error in object 'customer' on field 'postalCode': rejected value [gg551]; codes [Pattern.customer.postalCode,Pattern.postalCode,Pattern.java.lang.String,Pattern]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [customer.postalCode,postalCode]; arguments []; default message [postalCode],[Ljakarta.validation.constraints.Pattern$Flag;@395f0883,^[0-9]{5}]; default message [must contain 5 digits]
        Field error in object 'customer' on field 'lastName': rejected value [null]; codes [NotNull.customer.lastName,NotNull.lastName,NotNull.java.lang.String,NotNull]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [customer.lastName,lastName]; arguments []; default message [lastName]]; default message [is required]|
         */
        if(theBindingResult.hasErrors()){
            return "customer-form";
        }
        else {
            return "customer-confirmation";
        }

    }
}
