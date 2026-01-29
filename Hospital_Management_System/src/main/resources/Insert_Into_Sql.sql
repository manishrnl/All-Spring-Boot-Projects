INSERT INTO Patient (name, date_of_birth, email, gender, blood_group, created_at)
VALUES ('Amit Sharma', '1985-04-12', 'amit.sharma@example.com', 'Male', 'O+', NOW()),
       ('Neha Gupta', '1990-07-23', 'neha.gupta@example.com', 'Female', 'A+', NOW()),
       ('Rajesh Kumar', '1978-11-15', 'rajesh.kumar@example.com', 'Male', 'B-', NOW()),
       ('Pooja Singh', '2000-01-30', 'pooja.singh@example.com', 'Female', 'AB+', NOW()),
       ('Deepak Mehta', '1995-09-10', 'deepak.mehta@example.com', 'Male', 'O-', NOW());

INSERT INTO insurance (provider, policy_number, valid_until, created_at)
VALUES ("Reliance Health", "RH123456789", '2024-01-01', NOW()),
       ("Star Health", "SH987654321", '2023-06-15', NOW()),
       ("Max Bupa", "MB112233445", '2023-03-20', NOW()),
       ("Apollo Munich", "AM556677889", '2021-11-10', NOW()),
       ("HDFC ERGO", "HE998877665", '2022-08-05', NOW());


INSERT INTO Doctor (name, specialization, email)
VALUES ('Dr. Asha Verma', 'Cardiology', 'asha.verma@example.com'),
       ('Dr. Rajesh Patel', 'Neurology', 'rajesh.patel@example.com'),
       ('Dr. Lata Singh', 'Dermatology', 'lata.singh@example.com'),
       ('Dr. Vikram Kumar', 'Orthopedics', 'vikram.kumar@example.com'),
       ('Dr. Priya Menon', 'Pediatrics', 'priya.menon@example.com');


INSERT INTO Department (name, head_doctor_id)
VALUES ('Cardiology', 1),
       ('Neurology', 2),
       ('Dermatology', 3),
       ('Orthopedics', 4),
       ('Pediatrics', 5);

INSERT INTO Department_Doctors (department_id, doctors_id)
VALUES (1, 1),
       (1, 3), -- Cardiology department doctors
       (2, 2),
       (2, 5), -- Neurology department doctors
       (3, 3),
       (3, 4), -- Dermatology department doctors
       (4, 4),
       (4, 1), -- Orthopedics department doctors
       (5, 5),
       (5, 2); -- Pediatrics department doctors

INSERT INTO Appointment (appointment_time, reason, patient_id, doctor_id)
VALUES ('2025-10-15 09:00:00', 'Regular checkup', 1, 1),
       ('2025-10-16 10:30:00', 'Migraine consultation', 2, 2),
       ('2025-10-17 14:00:00', 'Skin rash treatment', 3, 3),
       ('2025-10-18 11:00:00', 'Knee pain evaluation', 4, 4),
       ('2025-10-19 15:30:00', 'Child vaccination', 5, 5);

