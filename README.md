# Three Problem 
## 문제 1
hashmap <key, value> 2개 테이블 중 key 를 중심으로 value order by desc 를 처리 한 후 콘솔에 출력하라.
> **(Array or List 등의 자바 배열을 통해 구현)**

**예시)**
|input(1)|key     |value(num)|     |input(2)|key     |value(char)|
|--------|--------|----------|-----|--------|--------|-----------|
|1       |`101 `  |'2'       |     |1       |`101 `  |'e'        |
|2       |`101 `  |'1'       |     |2       |`101 `  |'a'        |
|3       |`102 `  |'6'       |     |3       |`102 `  |'b'        |
|4       |`102 `  |'7'       |     |4       |`102 `  |'c'        |
|5       |`103 `  |'3'       |     |5       |`103 `  |'a'        |
|6       |`103 `  |'2'       |     |6       |`103 `  |'d'        |
> input 1,2 Data

|output|key     |value1(num)   |value2(char)  |
|------|--------|--------------|--------------|
|1     |`101 `  |'1'     	   | 'a'		  |
|2     |`101 `  |'1'           | 'e'          |
|3     |`101 `  |'2'           | 'a'          |
|4     |`101 `  |'2'           | 'e'          |
> 결과 출력

**문제 1 해답 정리**
- Input(1), Input(2) Data를 먼저 정렬한다.
- 정렬 후 Input(1)을 기준으로 Input(2) Data를 하나식 추가한다.

<br>

## 문제 2
 hashmap <key, value> 1개 테이블 중 key 를 중심으로 value 를 GROUPING 해서 콘솔에 출력 하도록 구현
 > 1번 문제와 동일
 
**예시)**
|input |key     |value(num)   |
|------|--------|--------------|
|1     |`101 `  |'1'     	   |
|2     |`101 `  |'2'           |
|3     |`101 `  |'3'           |
|4     |`102 `  |'5'           |
|5     |`102 `  |'6'     	   |
|6     |`103 `  |'1'     	   |
|7     |`103 `  |'2'     	   |
> Input Data

|output|key     |value(sort num)|
|------|--------|---------------|
|1     |`101 `  |'1','2','3'    |
|2     |`101 `  |'5','6'        |
|3     |`101 `  |'1','2'        |
>결과 출력

**문제 2 해답 정리**
- Input(1)의 데이터를 Key 기준으로 List에 넣은 후 정렬한다.
- 정렬된 리스트를 Key를 기준으로 Map넣고 출력한다.


<br>

## 문제 3
1억개 숫자 랜덤데이터를 효율적으로 정렬하는 메소드를 구현
> list , array 등의 배열 사용

<br>
**결과)**

|output|알고리즘                                  |시간          |
|------|-------------------------|-------------|
|1     |'퀵 정렬'                  |11.0 ~ 12.0  |
|2     |'분할 후 퀵정렬'             |10.0 ~ 11.0  |
|3     |'분할 후 더블 피벗 정렬'        |9.0 ~ 10.0  |


**문제 3 해답 정리**
- 자료구조 퀵정렬(피벗정렬), 이중 피벗 정렬을 먼저 구현한다.
- 먼저 N단위 기준으로 분할합니다. (1000만 단위일 경우, [1 ~ 1000만] ~  ... ~[9000만 1 ~ 1억] ) 
- 분할 후 선택한 정렬 알고리즘을 통해 정렬을 하면 됩니다. 
- 시간복잡도는 분할전 평균은 n*logn, 분할 후 n + (n/10 * log(n/10) * 10) 입니다.
   > 퀵정렬을 쓴다는 가정
- 어떤 컬렉션에 따라 시간 또한 변합니다.
   > 4천만개 기준,  Collection.sort시 ArrayList : 21s, LinkedList : 41s ..