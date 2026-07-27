CREATE TABLE doctor (
    id NUMBER(10),
    name VARCHAR2(100),
    salary NUMBER(10,2),

    CONSTRAINT pk_doctor PRIMARY KEY (id)
);


CREATE TABLE patient (
    id NUMBER(10),
    name VARCHAR2(100),
    age NUMBER(3),

    CONSTRAINT pk_patient PRIMARY KEY (id)
);


CREATE TABLE doctor_patient (
    doctor_id NUMBER(10),
    patient_id NUMBER(10),

    CONSTRAINT pk_doctor_patient PRIMARY KEY (doctor_id, patient_id),

    CONSTRAINT fk_doctor_patient_doctor
        FOREIGN KEY (doctor_id)
        REFERENCES doctor(id),

    CONSTRAINT fk_doctor_patient_patient
        FOREIGN KEY (patient_id)
        REFERENCES patient(id)
);