
public class array1 {
	public static void main(String[] args) {
		
	
	int score[] = { 7, 30, 40, 50, 60, 80 };

	for (int i = 0; i < score.length; i++) {				// ���� ū ���� ��� ���ϸ� ã�� ���� �ݺ��� ���
		int max = score[i];									// max ������ score[i]�� ���� �ְ�
		int count = i;										// count �������� �ݺ������� �����ϴ� i�� ���� ����

		for (int j = 0; j < score.length; j++) {			// ���⼭ ����� �ݺ����� ���� ���ذ��� �ƴ� �����ϸ� �ٲ�� ���� ��Ÿ��
			if (max < score[j]) {							// max �����ȿ� �ִ� ���� score[j]���� ������ 
				max = score[j];								// max�� ���� �� ū score[j]�� �ٲ�
				count = j;									// �׸��� count �������� �� ū j �� ��
			}
		}
		int temp = score[i];								// temp��� ������ ������ ���� ó�� ���� ����̾��� score[i]�� ���� �ְ�
		score[i] = score[count];							// score[i] ���� j�� �ٲ� score[count]�� ���� ����
		score[count] = temp;								// �׷� score[count]���� �Ʊ� score[i]�� ���� ������ �ξ��� temp�� ���� ����
	}
	for (int i = 0; i < score.length; i++) {
		System.out.println(score[i] + " ");
	}

}
}
