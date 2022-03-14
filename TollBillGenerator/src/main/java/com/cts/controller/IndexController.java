package com.cts.controller;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.entity.BankDetails;
import com.cts.entity.Manager;
import com.cts.entity.TollDetails;
import com.cts.entity.User;
import com.cts.entity.UserFeedback;
import com.cts.entity.UserTollDetails;
import com.cts.repository.BankRepository;
import com.cts.repository.ManagerRepository;
import com.cts.repository.TollDetailsRepository;
import com.cts.repository.UserFeedbackRepository;
import com.cts.repository.UserRepository;
import com.cts.repository.UserTollDetailsRepository;
import com.cts.service.AdminService;
import com.cts.service.ManagerService;
import com.cts.service.TollDetailsService;
import com.cts.service.UserFeedbackService;
import com.cts.service.UserService;

import lombok.*;

@Controller
public class IndexController {

	@Autowired
	private UserService uservice;

	@Autowired
	private ManagerService mservice;

	@Autowired
	private AdminService aservice;

	@Autowired
	private TollDetailsService tservice;

	@Autowired
	private UserFeedbackService ufservice;

	@Autowired
	private UserRepository urepo;

	@Autowired
	private ManagerRepository mrepo;

	@Autowired
	private TollDetailsRepository trepo;

	@Autowired
	private UserTollDetailsRepository utrepo;

	@Autowired
	private BankRepository brepo;

	/* @Author Anjusha */
	// Mapping for User Login page
	@GetMapping("/")
	public String indexUser() {
		return "indexUser";
	}

	/* @Author Anjusha */
	// Mapping for Manger Login page
	@GetMapping("/manager")
	public String indexManager() {
		return "indexManager";
	}

	/* @Author Anjusha */
	// Mapping for Admin login page
	@GetMapping("/admin")
	public String indexAdmin() {
		return "indexAdmin";
	}

	/* Registration of user */
	// Mapping for user registration page
	@GetMapping("/regUser")
	public String regUser(@ModelAttribute(name = "user") User user) {
		return "regUser";
	}

	/*
	 * @PostMapping("/regUser") public String regUserSave(@ModelAttribute User user,
	 * HttpSession session) { uservice.saveUser(user);
	 * session.setAttribute("regMsg", "Registered Sucessfully!!!"); return
	 * "redirect:/"; }
	 */

	/*
	 * @PostMapping("/regUser") public String
	 * regUserSave(@Valid @ModelAttribute(name = "user") User user, BindingResult
	 * result, HttpSession session) {
	 * 
	 * if (result.hasErrors()) { return "regUser"; } else {
	 * 
	 * uservice.saveUser(user); session.setAttribute("regMsg",
	 * "Registered Sucessfully!!!");
	 * 
	 * return "redirect:/"; } }
	 */

	/*
	 * For showing error while writing same email id and saving registration of user
	 */

	/* @Author Nayana */
	// validating user fields and checking uniqueness of email id
	@PostMapping("/regUser")
	public String regUserSave(@Valid @ModelAttribute(name = "user") User user, BindingResult result,
			HttpSession session, Model m) {
		if (result.hasErrors()) {
			return "regUser";
		}
		try {
			uservice.saveUser(user);
		} catch (Exception e) {
			m.addAttribute("errMsg", "* Email Id is already registered. Please use another email");
			return "regUser";
		}
		session.setAttribute("regMsg", "Registered Successfully!!!");
		return "redirect:/";
	}

	/* For mapping to manager registration page */
	@GetMapping("/regManager")
	public String regManager(@ModelAttribute(name = "manager") Manager manager) {
		return "regManager";
	}

	/* @Author Fazil */
	/* To check unique email while enetring manager registration */
	@PostMapping("/regManager")
	public String regManagerSave(@Valid @ModelAttribute(name = "manager") Manager manager, BindingResult result,
			HttpSession session, Model m) {
		if (result.hasErrors()) {
			return "regManager";
		}
		try {
			mservice.saveManager(manager);
		} catch (Exception e) {
			m.addAttribute("errMsg", "* Email Id is already registered. Please use another email");
			return "regManager";
		}
		session.setAttribute("regMsg", "Your Details are Submitted for Admin Approval!!!");
		return "redirect:/manager";
	}

	/*
	 * create table in mysql as well as add admin details in that table to run admin
	 * login
	 */

	/* @Author Rasheem */
	// validating admin
	@PostMapping("/loginAdmin")
	public String adminLogin(HttpSession session, @RequestParam String aemail, @RequestParam String apassword) {
		boolean isValidAdmin = aservice.validateAdmin(aemail, apassword);

		if (!isValidAdmin) {
			session.setAttribute("logMsg", "Invalid Credentials");
			return "redirect:/admin";
		} else {
			session.removeAttribute("logMsg");
			return "homeAdmin";
		}
	}

	/* @Author Anjusha */
	// getting all manager details as List
	@GetMapping("/managerDetails")
	public String showManagerDetails(Model m) {
		List<Manager> managerList = mservice.showAllManagers();
		m.addAttribute("managerList", managerList);
		return "managerDetails";
	}

	/* @Author Sachin */
	// checking user credentials for login
	@PostMapping("/loginUser")
	public String userLogin(@RequestParam String uuserName, @RequestParam String upassword, HttpSession session) {
		/*
		 * User user = urepo.findByUuserNameAndUpassword(uuserName, upassword); if (user
		 * == null) { session.setAttribute("logMsg", "Invalid Credentials"); return
		 * "redirect:/"; } else { return "homeUser"; }
		 */
		boolean isValidUser = uservice.validateUser(uuserName, upassword);
		if (!isValidUser) {
			session.setAttribute("logMsg", "Invalid Credentials");
			return "redirect:/";
		} else {
			session.removeAttribute("logMsg");
			session.removeAttribute("regMsg");
			User user = urepo.findByUuserNameAndUpassword(uuserName, upassword);
			session.setAttribute("eUser", user);
			return "homeUser";
		}
	}

	/* @Author Sachin */
	// checking Manager credentials for login
	@PostMapping("/loginManager")
	public String userManager(@RequestParam String muserName, @RequestParam String mpassword, HttpSession session) {

		boolean isValidManager = mservice.validateManager(muserName, mpassword);
		if (!isValidManager) {
			session.setAttribute("logMsg", "Invalid Credentials");
			return "redirect:/manager";
		} else {
			boolean approvedManager = mservice.approvedManager(muserName, mpassword);
			if (!approvedManager) {
				session.setAttribute("logMsg", "Registration not approved");
				session.removeAttribute("regMsg");
				return "redirect:/manager";
			}
			session.removeAttribute("logMsg");
			session.removeAttribute("regMsg");
			Manager eManager = mrepo.findByMuserNameAndMpassword(muserName, mpassword);
			session.setAttribute("eManager", eManager);
			return "homeManager";
		}
	}

	/*
	 * @GetMapping("/editManager/{mid}") public String
	 * editManager(@PathVariable(value = "mid")int mid, Model m) { Manager eManager
	 * = mrepo.findById(mid).orElse(null); m.addAttribute("eManager", eManager);
	 * return "editManager"; }
	 */

	/*
	 * @GetMapping("/modifyApproval/{mid}") public String
	 * editManager(@PathVariable(required = true, name = "mid") int mid, ModelMap
	 * model) { Manager eManager = mrepo.findById(mid).orElse(null);
	 * model.addAttribute("eManager", eManager); return "modifyApproval";
	 * 
	 * }
	 */

	/* @Author Sachin */
	// to show manager details to admin
	@GetMapping("/modifyApproval")
	public String modifyMapproval(@RequestParam int mid, ModelMap model) {
		Manager eManager = mrepo.findById(mid).orElse(null);
		model.addAttribute("eManager", eManager);
		return "modifyApproval";
	}

	/*
	 * @RequestMapping(value="/editsave",method = RequestMethod.POST) public String
	 * editsave(@ModelAttribute("student") Student emp){
	 * System.out.println("id is"+emp.getId()); studentService.update(emp); return
	 * "redirect:/viewstudents/1"; }
	 */

	/* @Author Sachin */
	// to save modified manager approval
	@PostMapping("/saveModifiedApproval")
	public String saveModifiedApprovalByAdmin(@ModelAttribute Manager eManager, HttpSession session) {
		mservice.saveManager(eManager);
		session.setAttribute("logMsg", "Approval Status changed Successfully!!!");
		return "redirect:/managerDetails";

	}

	/* @Author Sachin */
	// to delete manager registration
	@GetMapping("/deleteApproval")
	public String deleteMapproval(@RequestParam int mid, HttpSession session) {
		mrepo.deleteById(mid);
		session.setAttribute("logMsg", "Manager registration deleted Sucessfully!!!");
		return "redirect:/managerDetails";
	}
	/* @Author Rasheem */
	/* To show toll details to manager */
	@GetMapping("/tollDetailsIndex")
	public String viewTollDetailsByManager(Model m) {
		List<TollDetails> tollList = tservice.showAllTollDetails();
		m.addAttribute("tollList", tollList);
		return "tollDetailsManager";

	}
	/* @Author Rasheem */
	/* Map to add toll detail page by manager */
	@GetMapping("/addTollDetails")
	public String addTollDetailsByManager() {
		return "addTollDetails";
	}
	/* @Author Rasheem */
	/* To save toll details to repository by manager */
	@PostMapping("/saveTollDetail")
	public String saveTollDetailsByManager(@ModelAttribute TollDetails tollDetails, HttpSession session) {
		tservice.saveTollDetail(tollDetails);
		session.setAttribute("logMsg", "Toll Details Added Sucessfully!!!");
		return "redirect:/tollDetailsIndex";
	}
	/* @Author Anjusha */
	/* To edit a toll detail by manager */
	@GetMapping("/modifyTollDetails")
	public String modifyTollDetailsByManager(@RequestParam int tid, ModelMap model) {
		TollDetails etollDetails = trepo.findById(tid).orElse(null);
		model.addAttribute("etollDetails", etollDetails);
		return "editTollDetails";
	}
	/* @Author Anjusha */
	/* To update toll details modified by manager */
	@PostMapping("/updateTollDetails")
	public String updateTollDetailsByManager(@ModelAttribute TollDetails etollDetails, HttpSession session) {
		trepo.save(etollDetails);
		session.setAttribute("logMsg", "Toll Details Updated Successfully!!!");
		return "redirect:/tollDetailsIndex";
	}
	/* @Author Anjusha */
	/* To delete a toll detail by manager */
	@GetMapping("/deleteTollDetails")
	public String deleteTollDetailsByManager(@RequestParam int tid, HttpSession session) {
		trepo.deleteById(tid);
		session.setAttribute("logMsg", "Toll details deleted Sucessfully!!!");
		return "redirect:/tollDetailsIndex";
	}
	/* @Author Nayana */
	/* To show toll details to Admin */
	@GetMapping("/TollDetailsAdmin")
	public String viewTollDetailsByAdmin(Model m) {
		List<TollDetails> tollList = tservice.showAllTollDetails();
		m.addAttribute("tollList", tollList);
		return "tollDetailsAdmin";

	}
	/* @Author Nayana */
	/* To edit a toll detail by admin */
	@GetMapping("/modifyTollDetailsAdmin")
	public String modifyTollDetailsByAdmin(@RequestParam int tid, ModelMap model) {
		TollDetails etollDetails = trepo.findById(tid).orElse(null);
		model.addAttribute("etollDetails", etollDetails);
		return "editTollApprovalAdmin";
	}
	/* @Author Nayana */
	/* To update toll details modified by Admin */
	@PostMapping("/updateTollDetailsAdmin")
	public String updateTollDetailsByAdmin(@ModelAttribute TollDetails etollDetails, HttpSession session) {
		trepo.save(etollDetails);
		session.setAttribute("logMsg", "Toll Details Updated Successfully!!!");
		return "redirect:/TollDetailsAdmin";
	}
	/* @Author Nayana */
	/* To delete a toll detail by Admin */
	@GetMapping("/deleteTollDetailsAdmin")
	public String deleteTollDetailsByAdmin(@RequestParam int tid, HttpSession session) {
		trepo.deleteById(tid);
		session.setAttribute("logMsg", "Toll details deleted Sucessfully!!!");
		return "redirect:/TollDetailsAdmin";
	}
	/* @Author Rasheem */
	/* get to homepage of user */
	@GetMapping("/toHomepageUser")
	public String toHomepageUser() {
		return "homeUser";
	}
	/* @Author Rasheem */
	/* get to homepage of manager */
	@GetMapping("/toHomepageManager")
	public String toHomepageManager() {
		return "homeManager";
	}
	/* @Author Rasheem */
	/* get to homepage of admin */
	@GetMapping("/toHomepageAdmin")
	public String toHomepageAdmin() {
		return "homeAdmin";
	}  
	
	
	/* @Author fazil*/
	/* get to tolldetails of user */
	@GetMapping("/TollDetailsUser")
	public String showLocations(Model m) {
		List<TollDetails> locationsList = tservice.showAllTollDetails();
		m.addAttribute("locationsList", locationsList);
		return "userTollDetails";
	}
	/* @Author Anjusha */
	/* logout of user */
	@GetMapping("/logoutUser")
	public String userLogout(HttpSession session) {
		session.removeAttribute("eUser");
		return "indexUser";
	}
	/* @Author Anjusha */
	/* logout of manager */
	@GetMapping("/logoutManager")
	public String managerLogout(HttpSession session) {
		session.removeAttribute("eManager");
		return "indexManager";
	}
	/* @Author Anjusha */
	/* logout of admin */
	@GetMapping("/logoutAdmin")
	public String adminLogout(/* HttpSession session */) {
		/* session.removeAttribute("eManager"); */
		return "indexAdmin";
	} 
	
	/* @Author Nayana, Sachin,Rasheem*/
	/* go to add user feedback page */
	@GetMapping("/addUserFeedback")
	public String AddFeedbackbyUser() {
		return "addFeedbackUser";
	}
	/* @Author Nayana, Sachin,Rasheem*/
	/* To save feedback given by user */
	@PostMapping("/saveUserFeedback")
	public String saveUser(@ModelAttribute UserFeedback userFeedback, HttpSession session) {
		ufservice.saveUserFeedback(userFeedback);
		session.setAttribute("logMsg", "Feedback Added Sucessfully!!!");
		return "homeUser";
	}
	/* @Author Nayana, Sachin,Rasheem*/
	/* To show user feedback to admin */
	@GetMapping("/viewUserFeedbackByAdmin")
	public String viewUserFeedbackByAdmin(Model m) {
		List<UserFeedback> userFeedbackList = ufservice.showAllUserFeedback();
		m.addAttribute("userFeedbackList", userFeedbackList);
		return "userFeedbackDetailsAdmin";

	}
	/* @Author Nayana, Sachin,Rasheem*/
	@GetMapping("/addFeedbackDownloadMsg")
	public String addFeedbackDownloadMsgAdmin(HttpSession session) {
		session.setAttribute("logMsg", "Feedback Downloaded Sucessfully!!!");
		return "redirect:/viewUserFeedbackByAdmin";
	}
	/* @Author Nayana, Sachin,Rasheem*/
	@GetMapping("/addTollDetailsDownloadMsg")
	public String addTollDetailsDownloadMsgAdmin(HttpSession session) {
		session.setAttribute("logMsg", "Toll Details Downloaded Sucessfully!!!");
		return "redirect:/TollDetailsAdmin";
	}
	/* @Author Sachin,Fazil*/
	/* get to tolldetails of user */
	@PostMapping("/confirmPayment")
	public String showLocationsUser(Model m, @RequestParam String fsource, @RequestParam String fdestination,
			@RequestParam String fvtype, @RequestParam String foneortwo, @RequestParam int fprice,
			@RequestParam int ftid, @RequestParam String fjdate, HttpSession session) {

		User eUser = (User) session.getAttribute("eUser");
		UserTollDetails utDetails = new UserTollDetails();
		utDetails.setPrice(fprice);
		utDetails.setOneortwo(foneortwo);
		utDetails.setUser(eUser);

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		utDetails.setCreatedDate(date);

		DateTimeFormatter f = DateTimeFormatter.ofPattern("uuuu-MM-dd");
		LocalDate jdate = LocalDate.parse(fjdate, f);

		utDetails.setJourneyDate(jdate);

		TollDetails eTollDetails = trepo.findByFromLocationAndToLocationAndVechtype(fsource, fdestination, fvtype);

		utDetails.setTolldetails(eTollDetails);
		session.setAttribute("eprice", fprice);
		utrepo.save(utDetails);

		return "bankLoginBuying";
	}
	/* @Author Sachin,Fazil*/
	/* get to tolldetails of user */
	@PostMapping("/checkBankCredentials")
	public String checkingBankCrendentials(ModelMap m, HttpSession session, @RequestParam String buserName,
			@RequestParam String bpassword) {
		BankDetails eBankDetails = brepo.findByBuserNameAndBpassword(buserName, bpassword);
		if (eBankDetails == null) {
			session.setAttribute("logMsg", "Invalid Credentials");
			return "bankLoginBuying";
		} else {
			session.removeAttribute("logMsg");
			int balanceAmount = eBankDetails.getBalanceAmount();
			int charge = (int) session.getAttribute("eprice");
			
			balanceAmount = balanceAmount - charge;
			eBankDetails.setBalanceAmount(balanceAmount);
			brepo.save(eBankDetails);

			m.addAttribute("charge", charge);
			m.addAttribute("balanceAmount", balanceAmount);
			return "confirmationPage";
		}
	}
	/* @Author Sachin,Fazil*/
	@GetMapping("/editUserProfile")
	public String editUserProfileByUser(HttpSession session, ModelMap model) {

		User eUser = (User) session.getAttribute("eUser");
		model.addAttribute("eUser", eUser);
		return "editUserProfile";
	}
	/* @Author Sachin,Fazil*/
	@PostMapping("/updateUserProfile")
	public String updateUserProfileByUser(@Valid @ModelAttribute(name = "eUser") User eUser, BindingResult result,
			HttpSession session, Model m) {
		if (result.hasErrors()) {
			return "editUserProfile";
		}
		try {
			uservice.saveUser(eUser);
		} catch (Exception e) {
			m.addAttribute("errMsg", "* Email Id is already registered. Please use another email");
			return "editUserProfile";
		}
		session.setAttribute("logMsg", "Profile Updated Successfully!!!");
		session.setAttribute("eUser", eUser);
		return "homeUser";
	}

	/*
	 * To show toll details to Admin
	 * 
	 * @GetMapping("/TollDetailsAdmin") public String viewTollDetailsByAdmin(Model
	 * m) { List<TollDetails> tollList = tservice.showAllTollDetails();
	 * m.addAttribute("tollList", tollList); return "tollDetailsAdmin";
	 * 
	 * }
	 */
	/* @Author Sachin,Fazil*/
	@GetMapping("/viewUserJourneyDetails")
	public String viewUserJourneyDetailsByUser(Model m, HttpSession session) {
		User eUser = (User) session.getAttribute("eUser");
		int eUid = eUser.getUid();
		m.addAttribute("eUid", eUid);

		List<UserTollDetails> userTollList = utrepo.findAll();
		m.addAttribute("userTollList", userTollList);

		return "viewJourneyDetails";
	}
	/* @Author Sachin,Fazil*/
	@GetMapping("/deleteJourneyDetails")
	public String deleteJourneyDetailsByUser(@RequestParam int id, @RequestParam int price, HttpSession session,
			ModelMap model) {

		model.addAttribute("price", price);
		utrepo.deleteById(id);
		session.setAttribute("log1Msg", "Journey Cancelled Sucessfully!!!");
		return "bankLoginDeletion";

	}
	/* @Author Sachin,Fazil*/
	@PostMapping("/checkBankCredentialsDeletion")
	public String checkingBankCrendentialsDeletionUser(ModelMap m, HttpSession session, @RequestParam String buserName,
			@RequestParam String bpassword, @RequestParam int price) {
		BankDetails eBankDetails = brepo.findByBuserNameAndBpassword(buserName, bpassword);
		if (eBankDetails == null) {
			session.setAttribute("logMsg", "Invalid Credentials");
			m.addAttribute("price", price);
			return "bankLoginDeletion";
		} else {
			session.removeAttribute("logMsg");
			int balanceAmount = eBankDetails.getBalanceAmount();
			balanceAmount = balanceAmount + price;
			eBankDetails.setBalanceAmount(balanceAmount);
			brepo.save(eBankDetails);

			m.addAttribute("price", price);
			m.addAttribute("balanceAmount", balanceAmount);
			return "confirmationPageDeletion";
		}
	}
	
	//arjuns code
	
	@PostMapping("//ModifyTollDetailsUser")
	public String modifyLocationsUser(Model m, @RequestParam String fsource, @RequestParam String fdestination,
			@RequestParam String fvtype, @RequestParam String foneortwo, @RequestParam int fprice,
			@RequestParam int ftid, @RequestParam String fjdate, HttpSession session) {
		List<TollDetails> locationsList = tservice.showAllTollDetails();
		System.out.println("aaaaaaaaaaaaaaaaaa");
		System.out.println(fdestination);
		m.addAttribute("locationsList", locationsList);
		m.addAttribute("defaultSource", fsource);
		m.addAttribute("defaultDestination", fdestination);
		m.addAttribute("defaultVtype", fvtype);
		m.addAttribute("defaultOneorTwo", foneortwo);
		m.addAttribute("defaultPrice", fprice);
		m.addAttribute("modifyId", ftid);
		m.addAttribute("defaultJDate", fjdate);
		return "modifyUserTollDetails";
	}
	
	/* modify tolldetails of user */
	@PostMapping("/confirmModifyPayment")
	public String modifyConfirmPayment(Model m, @RequestParam String fsource, @RequestParam String fdestination,
			@RequestParam String fvtype, @RequestParam String foneortwo, @RequestParam int foldprice, @RequestParam int fprice,
			@RequestParam int ftid, @RequestParam String fjdate, HttpSession session) {

		User eUser = (User) session.getAttribute("eUser");
		UserTollDetails utDetails = new UserTollDetails();
		utDetails.setId(ftid);
		utDetails.setPrice(fprice);
		utDetails.setOneortwo(foneortwo);
		utDetails.setUser(eUser);

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		utDetails.setCreatedDate(date);

		DateTimeFormatter f = DateTimeFormatter.ofPattern("uuuu-MM-dd");
		LocalDate jdate = LocalDate.parse(fjdate, f);

		utDetails.setJourneyDate(jdate);

		TollDetails eTollDetails = trepo.findByFromLocationAndToLocationAndVechtype(fsource, fdestination, fvtype);

		utDetails.setTolldetails(eTollDetails);
		session.setAttribute("eprice", fprice);
		session.setAttribute("eoldprice", foldprice);
		System.out.println(fprice);
		System.out.println(foldprice);
		utrepo.save(utDetails);

		return "bankLoginModification";
	}
	@PostMapping("/checkBankCredentialsformodification")
	public String checkingBankCrendentialsformodification(ModelMap m, HttpSession session, @RequestParam String buserName,
			@RequestParam String bpassword) {
		BankDetails eBankDetails = brepo.findByBuserNameAndBpassword(buserName, bpassword);
		if (eBankDetails == null) {
			session.setAttribute("logMsg", "Invalid Credentials");
			return "bankLoginBuying";
		} else {
			session.removeAttribute("logMsg");
			int balanceAmount = eBankDetails.getBalanceAmount();
			int charge = (int) session.getAttribute("eprice");
			int oldcharge= (int)session.getAttribute("eoldprice");
			if(charge>oldcharge)
			{
				charge=charge-oldcharge;
				balanceAmount = balanceAmount - charge;
			}
			if(oldcharge>charge)
			{
				charge=oldcharge-charge;
				balanceAmount=balanceAmount+charge;
			}
			
			
			eBankDetails.setBalanceAmount(balanceAmount);
			brepo.save(eBankDetails);

			m.addAttribute("charge", charge);
			m.addAttribute("balanceAmount", balanceAmount);
			return "confirmationPage";
		}
	}
}
