
public class array1 {
	public static void main(String[] args) {
		
	
	int score[] = { 7, 30, 40, 50, 60, 80 };

	for (int i = 0; i < score.length; i++) {				// 가장 큰 값을 계속 비교하며 찾기 위해 반복문 사용
		int max = score[i];									// max 변수에 score[i]의 값을 넣고
		int count = i;										// count 변수에는 반복문으로 증가하는 i의 값을 넣음

		for (int j = 0; j < score.length; j++) {			// 여기서 사용한 반복문은 비교할 기준값이 아닌 증가하며 바뀌는 값을 나타냄
			if (max < score[j]) {							// max 변수안에 있는 값이 score[j]보다 작으면 
				max = score[j];								// max의 값은 더 큰 score[j]로 바뀜
				count = j;									// 그리고 count 변수에도 더 큰 j 가 들어감
			}
		}
		int temp = score[i];								// temp라는 정수형 변수를 만들어서 처음 비교할 대상이었던 score[i]의 값을 넣고
		score[i] = score[count];							// score[i] 에는 j로 바뀐 score[count]의 값을 넣음
		score[count] = temp;								// 그럼 score[count]에는 아까 score[i]의 값을 저장해 두었던 temp의 값을 넣음
	}
	for (int i = 0; i < score.length; i++) {
		System.out.println(score[i] + " ");
	}

}
}
