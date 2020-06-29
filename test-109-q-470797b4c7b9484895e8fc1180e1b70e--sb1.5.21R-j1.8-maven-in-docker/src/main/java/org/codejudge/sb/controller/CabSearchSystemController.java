package org.codejudge.sb.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.UniqueConstraint;
import javax.validation.Valid;

import org.codejudge.sb.enums.CabSearchSystemEnums;
import org.codejudge.sb.exception.ErrorResponse;
import org.codejudge.sb.model.AvailableCab;
import org.codejudge.sb.model.AvailableCabsMessage;
import org.codejudge.sb.model.DriverRegisterModel;
import org.codejudge.sb.model.DriverRegisterModelList;
import org.codejudge.sb.model.ShareDriverLocationModel;
import org.codejudge.sb.model.ShareDriverLocationStatus;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class CabSearchSystemController {

	private static final Logger log = LoggerFactory.getLogger(CabSearchSystemController.class);

	@PostMapping(path = "/driver/register", consumes = "application/json", produces = "application/json")
	public ResponseEntity<DriverRegisterModel> cabRegisterDriver(
			@Valid @RequestBody DriverRegisterModel driverRegisterModel) {
		log.info("Starting AppController with hello method calling...!!");
		System.out.println("driverRegisterModel ::!! " + driverRegisterModel.toString());
		Integer id = generateRandomId();
		driverRegisterModel.setId(id);
		if(driverRegisterModel.getName().equals("shafi"))
		{
			try {
				throw new SQLIntegrityConstraintViolationException();
			} catch (SQLIntegrityConstraintViolationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new ResponseEntity<>(driverRegisterModel, HttpStatus.CREATED);

	}

	@PostMapping(path = "/driver/{id}/sendLocation", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ShareDriverLocationStatus> shareDrvierLocation(@PathVariable("id") Integer id,
			@Valid @RequestBody ShareDriverLocationModel shareDriverLocationModel) {
		System.out.println("shareDriverLocationModel:: " + shareDriverLocationModel.getLatitude());
		ShareDriverLocationStatus shareDriverLocationStatus = new ShareDriverLocationStatus();
		shareDriverLocationStatus.setStatus(CabSearchSystemEnums.SUCCESS.value());
		return new ResponseEntity<>(shareDriverLocationStatus, HttpStatus.ACCEPTED);
	}

	@PostMapping(path = "/passenger/available_cabs", consumes = "application/json", produces = "application/json")
	public ResponseEntity onAvailableCabs(@Valid @RequestBody ShareDriverLocationModel shareDriverLocationModel) {

		DriverRegisterModelList driverRegisterModelList = null;
		Double km = shareDriverLocationModel.getLatitude() * shareDriverLocationModel.getLongitude();
		if (km > 4) {
			System.out.println("shareDriverLocationModel:: " + shareDriverLocationModel.getLatitude());
			driverRegisterModelList = new DriverRegisterModelList();
			AvailableCab availableCab = new AvailableCab();
			availableCab.setCarNumber("AP2020");
			availableCab.setName("shafi");

			availableCab.setPhoneNumber(99830);
			AvailableCab availableCab1 = new AvailableCab();
			availableCab1.setCarNumber("AP20201");
			availableCab1.setName("shafi1");
			availableCab1.setPhoneNumber(99831);

			List<AvailableCab> availableCabList = new ArrayList();
			availableCabList.add(availableCab);
			availableCabList.add(availableCab1);
			System.out.println("cabs available!");
			driverRegisterModelList.setAvailableCabs(availableCabList);
			
			for(AvailableCab cabs : availableCabList)
			{
				if(availableCabList.contains(cabs.getName()))
				{
					System.out.println("contains!");
					return new ResponseEntity<>(false, HttpStatus.OK);
				}
				 if(cabs.equals("shafi") || cabs.equals("shafi1"))
				{System.out.println("equals!");
					return new ResponseEntity<>(false, HttpStatus.OK);
				}
			}
			
			return new ResponseEntity<>(driverRegisterModelList, HttpStatus.OK);
		} else {
			AvailableCabsMessage availableCabsMessage = new AvailableCabsMessage();
			availableCabsMessage.setmessage(CabSearchSystemEnums.NOCABSAVAILABLE.value());
			System.out.println("No cabs available!");
			return new ResponseEntity<>(availableCabsMessage, HttpStatus.OK);
		}

	}

	private Integer generateRandomId() {
		Random rand = new Random(); // instance of random class
		int upperbound = 25;
		// generate random values from 0-24
		int int_random = rand.nextInt(upperbound);
		return int_random;
	}

}
