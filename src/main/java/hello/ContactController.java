package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {
	 @GetMapping("/contactList")
	    public String contactList(Model model) {
	        model.addAttribute("listContacts",contactRepository.findAll());
	        return "contactList";
	    }
	 
	 
	 
	 @GetMapping("/contactAdd")
	    public String contactAdd(Model model) {
		 model.addAttribute("contact", new Contact("",""));
	        return "contactAdd";
	    }
	 @GetMapping("/modifContact/{id}")
	    public String contactAdd(Model model, @PathVariable("id") long id) {
		 Contact c=contactRepository.findById(id);
		 model.addAttribute("contact", c);
	        return "contactAdd";
	    }
	 @PostMapping("/contactSave")
	    public String contactSave(Model model, Contact contact) {
		 contactRepository.save(contact);
	        return "redirect:/contactList";
	    }
	 
	 @GetMapping("/contactSuppr/{id}")
	    public String contactSuppr(@PathVariable("id") long id) {
		 contactRepository.delete(id);
	        return "redirect:/contactList";
	    }
	 @Autowired
	 ContactRepository contactRepository;
	 
}
