package za.ac.cput.domain.enums.domain;

import jakarta.persistence.*;
import za.ac.cput.domain.enums.domain.enums.ConfirmationStatus;
import za.ac.cput.domain.enums.domain.user.ClinicStaff;
import za.ac.cput.domain.enums.domain.user.Doctor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;

    private LocalDate appointmentDate;
    private LocalTime appointmentTime;

    @Enumerated(EnumType.STRING)
    private ConfirmationStatus confirmationStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id") // explicitly links doctor_id to the inherited userId variable
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id") // explicitly links staff_id to the inherited userId variable
    private ClinicStaff staff;

    protected Appointment() {
        // Required by JPA
    }

    private Appointment(Builder builder) {
        this.appointmentId = builder.appointmentId;
        this.appointmentDate = builder.appointmentDate;
        this.appointmentTime = builder.appointmentTime;
        this.confirmationStatus = builder.confirmationStatus;
        this.doctor = builder.doctor;
        this.staff = builder.staff;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public ConfirmationStatus getConfirmationStatus() {
        return confirmationStatus;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public ClinicStaff getStaff() {
        return staff;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime=" + appointmentTime +
                ", confirmationStatus=" + confirmationStatus +
                ", doctor=" + doctor +
                ", staff=" + staff +
                '}';
    }

    public static class Builder {
        private int appointmentId;
        private LocalDate appointmentDate;
        private LocalTime appointmentTime;
        private ConfirmationStatus confirmationStatus;
        private Doctor doctor;
        private ClinicStaff staff;

        public Builder setAppointmentId(int appointmentId) {
            this.appointmentId = appointmentId;
            return this;
        }

        public Builder setAppointmentDate(LocalDate appointmentDate) {
            this.appointmentDate = appointmentDate;
            return this;
        }

        public Builder setAppointmentTime(LocalTime appointmentTime) {
            this.appointmentTime = appointmentTime;
            return this;
        }

        public Builder setConfirmationStatus(ConfirmationStatus confirmationStatus) {
            this.confirmationStatus = confirmationStatus;
            return this;
        }

        public Builder setDoctor(Doctor doctor) {
            this.doctor = doctor;
            return this;
        }

        public Builder setStaff(ClinicStaff staff) {
            this.staff = staff;
            return this;
        }

        public Builder copy(Appointment appointment) {
            this.appointmentId = appointment.appointmentId;
            this.appointmentDate = appointment.appointmentDate;
            this.appointmentTime = appointment.appointmentTime;
            this.confirmationStatus = appointment.confirmationStatus;
            this.doctor = appointment.doctor;
            this.staff = appointment.staff;
            return this;
        }

        public Appointment build() {
            return new Appointment(this);
        }
    }
}
