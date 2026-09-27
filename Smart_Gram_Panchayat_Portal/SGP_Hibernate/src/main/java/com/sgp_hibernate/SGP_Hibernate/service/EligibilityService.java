package com.sgp_hibernate.SGP_Hibernate.service;

import java.time.LocalDate;
import java.time.Period;

import com.sgp_hibernate.SGP_Hibernate.entity.GovernmentScheme;
import com.sgp_hibernate.SGP_Hibernate.entity.User;

public class EligibilityService {
	
	public boolean cehckEligibility(User user, GovernmentScheme scheme) {
		
		int age = Period.between(user.getDateOfBirth(), LocalDate.now()).getYears();
		
		String gender = user.getGender();
		double income = user.getAnnualIncome();
		
		//Women Support Scheme
		if (scheme.getSchemeName().equalsIgnoreCase("Women Support Scheme")) {
			
			if (age >= 18 && gender.equalsIgnoreCase("Female") && income <= 200000) {
				
				return true;
				
			}
			
			return false;
			
		}
		
		// Senior Citizen Assistance Scheme
        if (scheme.getSchemeName().equalsIgnoreCase("Senior Citizen Assistance Scheme")) {

            if (age >= 60) {
                return true;
            }

            return false;
        }

        // Student Scholarship Scheme
        if (scheme.getSchemeName().equalsIgnoreCase("Student Scholarship Scheme")) {

            if (income <= 250000) {
                return true;
            }

            return false;
        }
		
		return false;
		
	}

}
