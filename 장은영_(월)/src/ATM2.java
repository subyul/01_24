import java.util.Scanner;

public class ATM2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int MAX = 5;
		int arrID[] = new int[MAX];
		int arrPW[] = new int[MAX];
		int Money[] = new int[MAX];
		int log = -1; // �α����ϸ� 1 �α׾ƿ��ϸ� -1
		int count = 0;
		int temp = 0;

		while (true) {
			System.out.println("=== �ް�IT ATM ===\n");
			System.out.println("1. ȸ������\n2. ȸ��Ż��\n3. �α���\n4. �α׾ƿ�");
			System.out.println("5. �Ա�\n6. ��ü\n7. �ܾ���ȸ\n8. ����");

			System.out.println("�̿��Ͻ� �޴��� �����ϼ���");
			int select = sc.nextInt();

			if (select == 1) 															// select�� 1�� �ԷµǸ� ȸ�������� ����
			{

				for (int k = 0; k < 5; k++)                                             // �Էµ� �����͸� Ȯ���ϱ� ���� �ݺ���
					System.out.println(arrID[k]+"  "+arrPW[k]);
				System.out.println("����� ID�� �Է��ϼ���");									// ����ڰ� �Է��� ���� ID�� ����ϱ� ����
				int dataID = sc.nextInt();												// dataID�� ������ ���
				int dataPW = 0;
				for (int i = 0; i < arrID.length; i++) {
					if (arrID[i] == 0) {												// arrID�� �迭�ȿ� �ִ� �����Ͱ� 0�̶��
						arrID[i] = dataID;												// 0 ��� dataID�� ����
						System.out.println("����� PW�� �Է��ϼ���");							// �н����嵵 ���̵�� ���� ������� ����
						dataPW = sc.nextInt();
						if (arrPW[i] == 0) {
							arrPW[i] = dataPW;
							Money[i] = 1000;
							System.out.println("1000���� �ԱݵǾ����ϴ�");
						}
						break;
					}

					else if (arrID[i] == dataID) {										// arrID�迭�� �����Ϳ� dataID�� ���ٸ�
						System.out.println("�ߺ��� ID�Դϴ�");								// �ߺ��Ǿ��ٴ� �޽����� ���
						break;
					}
				}
			}
			if (select == 3)															// select�� 3�� �ԷµǸ� �α����� ����
			{
				System.out.println("�α����� ID�� �Է��ϼ���"); 
				int inID = sc.nextInt();												// ȸ�����Կ��� �Է��� ���̵�� ���� ���� inID�� ����

				for (int i = 0; i < arrID.length; i++) {
					if (arrID[i] == inID) {												// arrID �迭�� �ִ� �����Ϳ� inID�� 
						System.out.println("�α����� PW�� �Է��ϼ���");						// ��ġ�Ѵٸ� �н����带 ���ϱ� ���� inPW ������ ������
						int inPW = sc.nextInt();
						if (arrPW[i] == inPW) {											// �н����嵵 ��ġ�Ѵٸ� 
							log = 1;													// �α����� �Ǿ����� �˱����� log ���� 1�� �ٲ�
							//												
							System.out.println("�α����� �Ϸ�Ǿ����ϴ�");						
						} else {
							System.out.println("�Է��� ������ ��ġ���� �ʽ��ϴ�");				
						}
					}
				}
			}
			if (select == 2) { 															// select�� 2�� �ԷµǸ� Ż�� ����
				while (true) {
					if ( /**/log == 1) {												// �α����� �Ǿ����� log�� 1�̱� ������ 
						System.out.println("Ż���� ID�� �Է��ϼ���");							// � ���̵� Ż���ų ������ ���̵� �Է¹���
						int delID = sc.nextInt();

						for (int i = 0; i < 5; i++) {
							if (arrID[i] == delID) {									// arrID�迭�� �ִ� �����Ϳ� Ż���ų ���̵�
																						// ��ġ�Ѵٸ� arrID�迭�� �ִ� �����͸� �����
								arrID[i] = arrID[i+1];									// ���� �ε����� �ִ� �����͸� ������ ������
								arrID[i+1] = arrID[i+2];
								arrID[i+2] = arrID[i+3];
								arrID[i+3] = arrID[i+4];
								arrID[i+4] = temp;
								arrPW[i] = arrPW[i+1];									// �н����� ���� ���̵�� ���� ������� ����
								arrPW[i+1] = arrPW[i+2];
								arrPW[i+2] = arrPW[i+3];
								arrPW[i+3] = arrPW[i+4];
								arrPW[i+4] = temp;
								
								System.out.println("ȸ��Ż�� �Ϸ�Ǿ����ϴ�");                
								break;													
							}
						

							else if (arrID[i] != delID) {       						// �迭�� �����Ϳ� ID�� ��ġ���� ���� ���
								System.out.println("ID�� ��ġ���� �ʽ��ϴ�");					// ID�� �ٽ� �Է��϶�� �޽����� ���
								break;
							}
						}
						break;
					} else if (log == -1) {												// log�� -1�̶�� �α����� �����ʾҴٴ� ������
						System.out.println("�α��νÿ��� �̿밡���մϴ�");						// �α��ν� �̿밡���ϴٴ� �޽����� ���
						break;
					}
				}
			}


			if (select == 4)															// select�� 4�� �ԷµǸ� �α׾ƿ��� ����
			{
				if (log == 1) {															// �α����� �Ǿ��ִ� ���¸� log�� 1�̹Ƿ�
					System.out.println("�α׾ƿ��� ���̵� �Է��ϼ���");							// �α׾ƿ� �� ���̵� �Է¹���
					int outID = sc.nextInt();
					for (int i = 0; i < arrID.length; i++) {
						if (arrID[i] == outID) {										// �迭�� �ִ� �����Ϳ� �α׾ƿ� �� ���̵�
							log = -1;													// ������ log�� -1�� �ٲ�
							System.out.println("�α׾ƿ� �Ǿ����ϴ�");
						}
					}
				} else if (log == -1) {													// ���� log�� -1�̶�� �α����� �Ǿ����� �ʴٴ�
					System.out.println("�α��νÿ��� �̿밡���մϴ�");							// ������ ����ڰ� �� �� �ִ� �޽��� ���
					break;
				}
			}

			if (select == 5)                                                            // select�� 5�� �ԷµǸ� �Ա��� ����
			{
				if (log == 1) {
					System.out.println("����Ȯ�ο� ���̵� �Է��ϼ���");							// ����Ȯ���� ���� ID�� �Է¹ް�
					int moneyID = sc.nextInt();											// moneyID�� ������ ����
					for (int i = 0; i < Money.length; i++) {
						if (moneyID == arrID[i]) {										// moneyID�� arrID �迭�� �ִ� ���� ��ġ�ϸ�
							System.out.println("�Ա��� �ݾ��� �Է��ϼ���");						// �󸶸� �Ա��� ������ �Է� �ް�
							int inMoney = sc.nextInt();									// inMoney ������ ������ ��
							Money[i] += inMoney;										// Money �迭�� �ִ� �����Ϳ� inMoney ���� ����
							System.out.println(Money[i]);
						}
					}
				} else if (log == -1) {
					System.out.println("�α��νÿ��� �̿밡���մϴ�");
				}
			}
			if (select == 6)															// select�� 6�� �ԷµǸ� ��ü�� ����
			{
				if (log == 1) {

					System.out.println("����Ȯ�ο� ���̵� �Է��ϼ���");							// ����Ȯ���� ���� ID�� �Է¹ް�
					int checkID = sc.nextInt();											// checkID�� ������ ����
					for (int i = 0; i < 5; i++) {
						if (checkID == arrID[i]) {										// checkID�� arrID�迭�� �����Ͱ� ��ġ�Ѵٸ�
							System.out.println("����Ȯ���� �Ϸ�Ǿ����ϴ�");
							System.out.println("��ü�� ���̵� �Է��ϼ���");					// ��ü�� ID�� �Է¹ް�
							int sendID = sc.nextInt();									// sendID�� ���� ��
							System.out.println("��ü�� �ݾ��� �Է��ϼ���");						// ��ü�� �ݾ��� �Է�
							int sendMoney = sc.nextInt();								// sendMoney�� ����

							Money[i] -= sendMoney;										// ��ü�� �ݾ��� �α����� ���¿��� ��
							for (int j = 0; j < 5; j++) {
								if (sendID == arrID[j]) {								// ��ü�� ���̵�� arrID�迭�� �����Ͱ� ��ġ�Ѵٸ�

									Money[j] += sendMoney;								// ��ü�� ���̵��� �迭�� �ε��� ��ȣ�� ���� ��ȣ�� �ִ�
								}														// Money �迭�� �����Ϳ� ����
							}
							System.out.println("��ü�� �Ϸ�Ǿ����ϴ�");
						}
					}
				} else if (log == -1) {
					System.out.println("�α��ν� �̿밡���մϴ�");
				}
			}
			if (select == 7) { 															// select�� 7�� �ԷµǸ� �ܾ���ȸ�� ����
				if (log == 1) {
					System.out.println("����Ȯ�ο� ���̵� �Է��ϼ���");							// �α����� �Ǿ��ٸ� ����Ȯ���� ���� ID�� �Է¹ް�
					int checkID2 = sc.nextInt();										// checkID2 ������ ����

					for (int i = 0; i < 5; i++) {
						if (checkID2 == arrID[i]) {										// Ȯ�ο� ID�� arrID�迭�� �ִ� �����Ͱ� ��ġ�Ѵٸ�
							System.out.println("���¿� " + Money[i] + "�� �ֽ��ϴ�");			// Money�迭 �����͸� ���
						}
					}
				} else if (log == -1) {
					System.out.println("�α��ν� �̿밡���մϴ�");
				}
			}

			if (select == 8) { 															// select�� 8�� �ԷµǸ� ���� ����
				System.out.println("ATM�� �����մϴ�...");
				break;																	// while���� ���������� ���� break ���
			}
		}
	}
}
