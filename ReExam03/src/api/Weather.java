package api;

public class Weather {

		// 필드 생성
		private int temp;
		private String wfKor;
		private int hour;
		
		
		public int getTemp() {
			return temp;
		}
		public void setTemp(int temp) {
			this.temp = temp;
		}
		public String getWfKor() {
			return wfKor;
		}
		public void setWfKor(String wfKor) {
			this.wfKor = wfKor;
		}
		public int getHour() {
			return hour;
		}
		public void setHour(int hour) {
			this.hour = hour;
		}
		
		
		@Override
		public String toString() {
			return  + hour + "시," + " " + temp  + "도," + " " + wfKor + "\n" ;
		}
		
		
		
		
		
		
	

}
