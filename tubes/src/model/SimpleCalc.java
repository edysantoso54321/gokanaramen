public class SimpleCalc{
	private double first, second;
	private String x;
        public void setFirst(double first){
		this.first = first;
	}
	public void setSecond(double second){
		this.second = second;
	}
	public double sum(){
		return first+second;
	}
	public double diff(){
		return first-second;
	}
        public void setX(String x){
            this.x=x;
        }
        public String addslash(){
            int idx=x.length();
            while(idx>0){
                if(x.charAt(idx-1)=='\\') x = x.substring(0, idx-1)+'\\'+x.substring(idx-1, x.length());
                else if(x.charAt(idx-1)=='\'') x = x.substring(0, idx-1)+'\\'+x.substring(idx-1, x.length());
                idx--;
            }
            return x;
        }
        public boolean isnumber(){
            try{
                Integer.parseInt(x);
                return true;
            }catch(Exception e){
                return false;
            }
        }
}