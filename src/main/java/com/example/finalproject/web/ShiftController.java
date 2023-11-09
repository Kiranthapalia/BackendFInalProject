package com.example.finalproject.web;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.finalproject.domain.DepartmentRepository;
import com.example.finalproject.domain.Shift;
import com.example.finalproject.domain.ShiftRepository;
import com.example.finalproject.domain.AppUserRepository;

@Controller
public class ShiftController {

	@Autowired
	private ShiftRepository shiftRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private AppUserRepository userRepository;

	// a method to provide status options
	@ModelAttribute("allStatuses")
	public List<String> allStatuses() {
		return Arrays.asList("Active", "Pending", "Completed");
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// Show all shifts
	@RequestMapping("/shiftlist")
	public String shiftList(Model model, Principal principal) {
		String username = principal.getName(); // Get the username of the logged-in user
		List<Shift> shifts;
		if (isAdmin(principal)) {
			shifts = (List<Shift>) shiftRepository.findAll(); // Fetch all shifts for the admin
		} else {
			shifts = shiftRepository.findByAssigned(username); // Fetch shifts assigned to the logged-in user
		}
		model.addAttribute("shifts", shifts);
		return "shiftlist";
	}

//checks if the user has the role "ADMIN":
	private boolean isAdmin(Principal principal) {
		if (principal instanceof Authentication) {
			Authentication authentication = (Authentication) principal;
			return authentication.getAuthorities().stream()
					.anyMatch(authority -> authority.getAuthority().equals("ADMIN"));
		}
		return false;
	}

	// RESTful service to get all shifts
	@RequestMapping(value = "/shifts", method = RequestMethod.GET)
	public @ResponseBody List<Shift> shiftListRest() {
		return (List<Shift>) shiftRepository.findAll();
	}

	// RESTful service to get shift by id
	@RequestMapping(value = "/shift/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Shift> findShiftRest(@PathVariable("id") Long shiftId) {
		return shiftRepository.findById(shiftId);
	}

	// Add new shift
	@RequestMapping(value = "/add")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addShift(Model model) {
		model.addAttribute("shift", new Shift());
		model.addAttribute("departments", departmentRepository.findAll());
		model.addAttribute("users", userRepository.findAll());
		model.addAttribute("statuses", allStatuses());
		return "addshift";
	}

	// Save the shift
	@PostMapping("/save")
	public String saveShift(@ModelAttribute Shift shift) {
		String formattedStartDate = shift.getStartDate().replace("T", " ");
		String formattedEndDate = shift.getEndDate().replace("T", " ");
		shift.setStartDate(formattedStartDate);
		shift.setEndDate(formattedEndDate);
		shiftRepository.save(shift);
		return "redirect:shiftlist";
	}

	// Delete shift
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteShift(@PathVariable("id") Long shiftId, Model model) {
		shiftRepository.deleteById(shiftId);
		return "redirect:../shiftlist";
	}

	// Update shift
	@RequestMapping(value = "/edit/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editShift(@PathVariable("id") Long shiftId, Model model) {
		model.addAttribute("statuses", allStatuses());
		Optional<Shift> shift = shiftRepository.findById(shiftId);
		if (shift.isPresent()) {
			model.addAttribute("shift", shift.get());
			model.addAttribute("departments", departmentRepository.findAll());
			model.addAttribute("users", userRepository.findAll());
			return "editshift";
		} else {
			return "shiftlist"; // Redirect to the shift list if not found
		}
	}
}
