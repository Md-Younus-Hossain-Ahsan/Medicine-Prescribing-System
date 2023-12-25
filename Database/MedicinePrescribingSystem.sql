create database medicine_prescribing_system

	
CREATE TABLE Doctor_Info (
    doc_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    mobile_number VARCHAR(15) NOT NULL,
    qualifications VARCHAR(2000),
	profile_pic BLOB
) AUTO_INCREMENT = 1001;

INSERT INTO Doctor_Info (username, name, password, email, gender, mobile_number, qualifications, profile_pic)
VALUES ('user', 'Mr. Someone', '12345', 'doctor@example.com', 'Male', '1234567890', 'MBBS, MD', NULL);



CREATE TABLE Medicine (
    med_id INT AUTO_INCREMENT PRIMARY KEY,
    med_name VARCHAR(255) NOT NULL,
    med_type VARCHAR(50)
) AUTO_INCREMENT = 101;



CREATE TABLE Chamber (
    Chamber_id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Email VARCHAR(255),
    Location VARCHAR(255),
    Visiting_time VARCHAR(255),
    Days VARCHAR(255),
    Fee INT,
	MobileNumbers VARCHAR(255)
) AUTO_INCREMENT = 1001;



CREATE TABLE Appointment (
    SI_no INT,
	Chamber_id INT,
	App_id VARCHAR(20) NOT NULL,
    Name VARCHAR(255) NOT NULL,
    Age INT,
    Mobile_Number VARCHAR(15) NOT NULL,
    Gender VARCHAR(10) NOT NULL,
    App_date DATE,
	App_type VARCHAR(10) NOT NULL,
	FOREIGN KEY (Chamber_id) REFERENCES Chamber(Chamber_id)
);



CREATE TABLE Patient (
    Patient_id INT AUTO_INCREMENT PRIMARY KEY,
	Name VARCHAR(50) NOT NULL,
    Age INT,
    Mobile_Number VARCHAR(15) NOT NULL,
    Gender VARCHAR(10) NOT NULL
) AUTO_INCREMENT = 10001;



CREATE TABLE Test (
    Test_id INT AUTO_INCREMENT PRIMARY KEY,
	Name VARCHAR(50) NOT NULL    
) AUTO_INCREMENT = 101;



CREATE TABLE Diseases (
    Dis_id INT AUTO_INCREMENT PRIMARY KEY,
    details VARCHAR(50)
);



CREATE TABLE Prescription (
    Pres_id INT AUTO_INCREMENT PRIMARY KEY,
    Chamber_id INT,
    Patient_id INT,
    Patient_age INT,
	NextAppointment VARCHAR(50),
	Visiting_Date VARCHAR(50),
    FOREIGN KEY (Chamber_id) REFERENCES Chamber(Chamber_id),
    FOREIGN KEY (Patient_id) REFERENCES Patient(Patient_id)
) AUTO_INCREMENT = 1001;



CREATE TABLE Prescribed_Medicines (
    PresMed_id INT AUTO_INCREMENT PRIMARY KEY,
	Pres_id INT,
    med_id INT,
    dosage_routine VARCHAR(50),
    period VARCHAR(50),
    duration VARCHAR(50),
	dosage_condition VARCHAR(50),    
    FOREIGN KEY (Pres_id) REFERENCES Prescription(Pres_id),
    FOREIGN KEY (med_id) REFERENCES medicine(med_id)
);



CREATE TABLE Advices (
    Adv_id INT AUTO_INCREMENT PRIMARY KEY,
	Pres_id INT,
    details VARCHAR(250),
    FOREIGN KEY (Pres_id) REFERENCES Prescription(Pres_id)
);



CREATE TABLE Finding_Problems (
    FindProb_id INT AUTO_INCREMENT PRIMARY KEY,
	Pres_id INT,
    Dis_id INT,
    FOREIGN KEY (Pres_id) REFERENCES Prescription(Pres_id),
    FOREIGN KEY (Dis_id) REFERENCES Diseases(Dis_id)
);



CREATE TABLE Prescribed_Tests (
    PresTest_id INT AUTO_INCREMENT PRIMARY KEY,
	Pres_id INT,
    Test_id INT,
    FOREIGN KEY (Pres_id) REFERENCES Prescription(Pres_id),
    FOREIGN KEY (Test_id) REFERENCES Test(Test_id)
);
