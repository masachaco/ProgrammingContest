package lamnic.com.aoj;

public class Problem0000 {
	public static void solve(){
		for(int i = 1;i<10;i++){
			for(int n = 1;n<10;n++){
				System.out.println(String.format("%dx%d=%d",i,n,i*n));
			}
		}
	}
}
