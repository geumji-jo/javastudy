package ex05_lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@NoArgsConstructor	//매개변수가 없는 생성자
@AllArgsConstructor
@Getter
@Setter
public class User {
	
	private String id;
	private String pw;
	

}
