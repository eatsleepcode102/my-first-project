package dp.creational.builder;

public class Student{
	
	private String hoten;
	private int tuoi;
	private boolean isSingle;
	private double chieucao;
	private double cannang;
	
	public Student(StudentBuilder builder) {
		this.hoten = builder.hoten;
		this.tuoi = builder.tuoi;
		this.isSingle=builder.isSingle;
		this.chieucao=builder.chieucao;
		this.cannang=builder.cannang;
	}

	public boolean isSingle() {
		return isSingle;
	}

	public void setSingle(boolean isSingle) {
		this.isSingle = isSingle;
	}

	public double getChieucao() {
		return chieucao;
	}

	public void setChieucao(double chieucao) {
		this.chieucao = chieucao;
	}

	public double getCannang() {
		return cannang;
	}

	public void setCannang(double cannang) {
		this.cannang = cannang;
	}

	@Override
	public String toString() {
		return "Student: hoten="+this.hoten+", tuoi="+this.tuoi+", docthan="+this.isSingle+", chieucao="+this.chieucao+", "+this.cannang;
	}

	public static class StudentBuilder {
		private String hoten;
		private int tuoi;
		private boolean isSingle;
		private double chieucao;
		private double cannang;
		
		
		
		public StudentBuilder(String hoten, int tuoi) {
			super();
			this.hoten = hoten;
			this.tuoi = tuoi;
		}
		


		public boolean isSingle() {
			return isSingle;
		}



		public StudentBuilder setSingle(boolean isSingle) {
			this.isSingle = isSingle;
			return this;
		}



		public double getChieucao() {
			return chieucao;
		}



		public StudentBuilder setChieucao(double chieucao) {
			this.chieucao = chieucao;
			return this;
		}



		public double getCannang() {
			return cannang;
		}



		public StudentBuilder setCannang(double cannang) {
			this.cannang = cannang;
			return this;
		}



		public Student build() {
			return new Student(this);
		}
		
	}
}


