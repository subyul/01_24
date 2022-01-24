import java.util.Scanner;

public class ATM2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int MAX = 5;
		int arrID[] = new int[MAX];
		int arrPW[] = new int[MAX];
		int Money[] = new int[MAX];
		int log = -1; // 로그인하면 1 로그아웃하면 -1
		int count = 0;
		int temp = 0;

		while (true) {
			System.out.println("=== 메가IT ATM ===\n");
			System.out.println("1. 회원가입\n2. 회원탈퇴\n3. 로그인\n4. 로그아웃");
			System.out.println("5. 입금\n6. 이체\n7. 잔액조회\n8. 종료");

			System.out.println("이용하실 메뉴를 선택하세요");
			int select = sc.nextInt();

			if (select == 1) 															// select에 1이 입력되면 회원가입을 실행
			{

				for (int k = 0; k < 5; k++)                                             // 입력된 데이터를 확인하기 위한 반복문
					System.out.println(arrID[k]+"  "+arrPW[k]);
				System.out.println("사용할 ID를 입력하세요");									// 사용자가 입력한 값을 ID로 사용하기 위해
				int dataID = sc.nextInt();												// dataID란 변수를 사용
				int dataPW = 0;
				for (int i = 0; i < arrID.length; i++) {
					if (arrID[i] == 0) {												// arrID란 배열안에 있는 데이터가 0이라면
						arrID[i] = dataID;												// 0 대신 dataID를 넣음
						System.out.println("사용할 PW를 입력하세요");							// 패스워드도 아이디와 같은 방식으로 실행
						dataPW = sc.nextInt();
						if (arrPW[i] == 0) {
							arrPW[i] = dataPW;
							Money[i] = 1000;
							System.out.println("1000원이 입금되었습니다");
						}
						break;
					}

					else if (arrID[i] == dataID) {										// arrID배열의 데이터와 dataID가 같다면
						System.out.println("중복된 ID입니다");								// 중복되었다는 메시지를 출력
						break;
					}
				}
			}
			if (select == 3)															// select에 3이 입력되면 로그인을 실행
			{
				System.out.println("로그인할 ID를 입력하세요"); 
				int inID = sc.nextInt();												// 회원가입에서 입력한 아이디와 비교할 변수 inID를 만듦

				for (int i = 0; i < arrID.length; i++) {
					if (arrID[i] == inID) {												// arrID 배열에 있는 데이터와 inID가 
						System.out.println("로그인할 PW를 입력하세요");						// 일치한다면 패스워드를 비교하기 위해 inPW 변수를 선언함
						int inPW = sc.nextInt();
						if (arrPW[i] == inPW) {											// 패스워드도 일치한다면 
							log = 1;													// 로그인이 되었음을 알기위해 log 값을 1로 바꿈
							//												
							System.out.println("로그인이 완료되었습니다");						
						} else {
							System.out.println("입력한 정보가 일치하지 않습니다");				
						}
					}
				}
			}
			if (select == 2) { 															// select에 2가 입력되면 탈퇴를 실행
				while (true) {
					if ( /**/log == 1) {												// 로그인이 되었으면 log가 1이기 때문에 
						System.out.println("탈퇴할 ID를 입력하세요");							// 어떤 아이디를 탈퇴시킬 것인지 아이디를 입력받음
						int delID = sc.nextInt();

						for (int i = 0; i < 5; i++) {
							if (arrID[i] == delID) {									// arrID배열에 있는 데이터와 탈퇴시킬 아이디가
																						// 일치한다면 arrID배열에 있던 데이터를 지우고
								arrID[i] = arrID[i+1];									// 다음 인덱스에 있던 데이터를 앞으로 가져옴
								arrID[i+1] = arrID[i+2];
								arrID[i+2] = arrID[i+3];
								arrID[i+3] = arrID[i+4];
								arrID[i+4] = temp;
								arrPW[i] = arrPW[i+1];									// 패스워드 또한 아이디와 같은 방식으로 실행
								arrPW[i+1] = arrPW[i+2];
								arrPW[i+2] = arrPW[i+3];
								arrPW[i+3] = arrPW[i+4];
								arrPW[i+4] = temp;
								
								System.out.println("회원탈퇴가 완료되었습니다");                
								break;													
							}
						

							else if (arrID[i] != delID) {       						// 배열의 데이터와 ID가 일치하지 않을 경우
								System.out.println("ID가 일치하지 않습니다");					// ID를 다시 입력하라는 메시지를 출력
								break;
							}
						}
						break;
					} else if (log == -1) {												// log가 -1이라면 로그인이 되지않았다는 뜻으로
						System.out.println("로그인시에만 이용가능합니다");						// 로그인시 이용가능하다는 메시지를 출력
						break;
					}
				}
			}


			if (select == 4)															// select에 4가 입력되면 로그아웃을 실행
			{
				if (log == 1) {															// 로그인이 되어있는 상태면 log가 1이므로
					System.out.println("로그아웃할 아이디를 입력하세요");							// 로그아웃 할 아이디를 입력받음
					int outID = sc.nextInt();
					for (int i = 0; i < arrID.length; i++) {
						if (arrID[i] == outID) {										// 배열에 있는 데이터와 로그아웃 할 아이디가
							log = -1;													// 같으면 log는 -1로 바뀜
							System.out.println("로그아웃 되었습니다");
						}
					}
				} else if (log == -1) {													// 만약 log가 -1이라면 로그인이 되어있지 않다는
					System.out.println("로그인시에만 이용가능합니다");							// 뜻으로 사용자가 알 수 있는 메시지 출력
					break;
				}
			}

			if (select == 5)                                                            // select에 5가 입력되면 입금을 실행
			{
				if (log == 1) {
					System.out.println("본인확인용 아이디를 입력하세요");							// 본인확인을 위한 ID를 입력받고
					int moneyID = sc.nextInt();											// moneyID란 변수에 저장
					for (int i = 0; i < Money.length; i++) {
						if (moneyID == arrID[i]) {										// moneyID와 arrID 배열에 있는 값이 일치하면
							System.out.println("입금할 금액을 입력하세요");						// 얼마를 입금할 것인지 입력 받고
							int inMoney = sc.nextInt();									// inMoney 변수에 저장한 후
							Money[i] += inMoney;										// Money 배열에 있는 데이터에 inMoney 값을 더함
							System.out.println(Money[i]);
						}
					}
				} else if (log == -1) {
					System.out.println("로그인시에만 이용가능합니다");
				}
			}
			if (select == 6)															// select에 6이 입력되면 이체를 실행
			{
				if (log == 1) {

					System.out.println("본인확인용 아이디를 입력하세요");							// 본인확인을 위한 ID를 입력받고
					int checkID = sc.nextInt();											// checkID란 변수에 저장
					for (int i = 0; i < 5; i++) {
						if (checkID == arrID[i]) {										// checkID와 arrID배열의 데이터가 일치한다면
							System.out.println("본인확인이 완료되었습니다");
							System.out.println("이체할 아이디를 입력하세요");					// 이체할 ID를 입력받고
							int sendID = sc.nextInt();									// sendID에 저장 후
							System.out.println("이체할 금액을 입력하세요");						// 이체할 금액을 입력
							int sendMoney = sc.nextInt();								// sendMoney에 저장

							Money[i] -= sendMoney;										// 이체할 금액을 로그인한 계좌에서 뻼
							for (int j = 0; j < 5; j++) {
								if (sendID == arrID[j]) {								// 이체할 아이디와 arrID배열의 데이터가 일치한다면

									Money[j] += sendMoney;								// 이체할 아이디의 배열의 인덱스 번호와 같은 번호에 있는
								}														// Money 배열의 데이터에 더함
							}
							System.out.println("이체가 완료되었습니다");
						}
					}
				} else if (log == -1) {
					System.out.println("로그인시 이용가능합니다");
				}
			}
			if (select == 7) { 															// select에 7이 입력되면 잔액조회를 실행
				if (log == 1) {
					System.out.println("본인확인용 아이디를 입력하세요");							// 로그인이 되었다면 본인확인을 위해 ID를 입력받고
					int checkID2 = sc.nextInt();										// checkID2 변수에 저장

					for (int i = 0; i < 5; i++) {
						if (checkID2 == arrID[i]) {										// 확인용 ID와 arrID배열에 있는 데이터가 일치한다면
							System.out.println("계좌에 " + Money[i] + "원 있습니다");			// Money배열 데이터를 출력
						}
					}
				} else if (log == -1) {
					System.out.println("로그인시 이용가능합니다");
				}
			}

			if (select == 8) { 															// select에 8이 입력되면 종료 실행
				System.out.println("ATM을 종료합니다...");
				break;																	// while문을 빠져나가기 위해 break 사용
			}
		}
	}
}
