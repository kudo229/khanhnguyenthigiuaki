package threadthigiuaki;

import java.time.LocalDate;
import java.time.Period;

public class caclculatorthreads implements Runnable {
	private Student student;
	public caclculatorthreads(Student student) {
		this.student = student;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		LocalDate birthDate = LocalDate.parse(student.getDateOfBirth());
		LocalDate today = LocalDate.now();
		 Period age = Period.between(birthDate, today);
		 String encodedAge = encodeAge(age.getYears());
		}
	private String encodeAge(int years) {
		// TODO Auto-generated method stub
		return String.valueOf(years);
	}

}