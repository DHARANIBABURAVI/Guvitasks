package Stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginsteps {


	@Given("I want to write a step with precondition")
	public void i_want_to_write_a_step_with_precondition() throws InterruptedException {   
		System.out.println("dharani");
		page.login();
			}

	@Given("checking whether the given condition is broken")
	public void checking_whether_the_given_condition_is_broken() {
		page.checkurl();
	}

	@When("user signing in with correct credentials")
	public void user_signing_in_with_correct_credentials() throws Throwable {
		page.signin();
	}

	@Then("navigation of menu and title verification")
	public void navigation_of_menu_and_title_verification()throws Throwable {
		page.validation();
	}

	@When("yet another action")
	public void yet_another_action() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("check more outcomes")
	public void check_more_outcomes() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	//=============================================================================================================
	@Given("enters into the url")
	public void enters_into_the_url() throws InterruptedException {
	   page.spicejeturl();
	}
	

	@Given("user tries to login")
public void user_tries_to_login() throws InterruptedException {
   page.spicejetlogin();
}

@Then("filling the mandatory fields")
public void  filling_the_mandatory_fields() throws InterruptedException {
	page.mandatoryfields();
}
	
@And("Book flights for both oneway and roundtrip")
public void  Book_flights_for_both_oneway_and_roundtrip() throws InterruptedException {
	page.bookflights();
}
	
@Then("select a flight and proceed to the booking page")
public void  select_a_flight_and_proceed_to_the_booking_page () throws InterruptedException {
	page.selectglight();
}
	
	
	
	
	
	
	
	
}
