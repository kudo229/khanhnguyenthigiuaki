package threadthigiuaki;
import java.time.LocalDate;

public class bai3songuyento implements Runnable{

		private Student student;
		private boolean isPrime;

		public bai3songuyento(Student student) {
			this.student = student;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			int sum = calculateSumOfDigits(student.getDateOfBirth());
			boolean isPrime = soNguyento(sum);
		}
		private int calculateSumOfDigits(String dateOfBirth) {
			LocalDate birthDate = LocalDate.parse(dateOfBirth);
			int day = birthDate.getDayOfMonth();
			int month = birthDate.getMonthValue();
			int year = birthDate.getYear();
			int sum = 0;
			while (day >0) {
				sum += day % 10;
				day /= 10;
			}
			while ( month >0) {
				sum += month % 10;
	            month /= 10;
			}
			while (year > 0) {
	            sum += year % 10;
	            year /= 10;
	        }
			return sum;
		}
		public static boolean soNguyento(int sum) {
		    if (sum <= 1) {
		        return false;
		    }

		    for (int i = 2; i <= Math.sqrt(sum); i++) {
		        if (sum % i == 0) {
		            return false;
		        }
		    }
		    return true;
		}

	}
