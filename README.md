<h1>인스타그램 클론 프로젝트 </h1>
<div>
  <b>자바 스프링을 이용해 만든 인스타그램 클론 웹사이트 개발</b>
</div>
<br>
<div>
  <b>사용 기술</b>
  <br>
  Spring, Java, MySQL, HTML, CSS, Bootstrap, JavaScrpit, Thymeleaf, lombok, JPA, mybatis
</div>
<br>
<div>
  시작일 : 2024년 07월 29일
  <br>
  종료일 : 2024년 09월 02일
</div>

<h3>일정표</h3>
https://docs.google.com/spreadsheets/d/1QJVjdZvttGgFFo3KqmKOFznd6J5evbU15bOu7DIunmo/edit?usp=sharing
<br>


<h3>DB설계서, URL 기획서</h3>
https://docs.google.com/spreadsheets/d/1Dme_0goq8qt7FFXQe4bDaYsR6-dDV3rv8gpoxJ6ijHA/edit?usp=sharing

<hr>
<div>
  <h3>대표 기능</h3>
  1. 로그인, 로그아웃, 회원가입
  <br>
  2. 타임라인 
  <br>
  3. 프로필 사진 업로드
  <br>
  4. 글 업로드, 삭제 
  <br>
  5. 게시글 좋아요, 해제
  <br>
  6. 게시글 댓글 쓰기, 삭제
  <br>
  7. 팔로잉, 팔로우
  <br>
  8. 자기소개, 성별
  <br>
  9. 카카오톡 로그인 (오류발생)
</div>


<hr>

<h1>1. 주제 선정</h1>

<div>
  평소 인스타그램과 sns를 자주 써서 sns개발에 흥미가 있었습니다.
  그래서 처음 코딩을 배웠을 때, 언젠가 sns를 만들고 싶다는 욕심이 있었고 백엔드 프로젝트 주제로 sns의 가장 대표 웹페이지인 Instargram을 자바 spring을 활용해 개발하게 되었습니다.
</div>

<h1>2. Figma를 활용한 UI 디자인</h1>
<div>
  https://www.figma.com/design/wHUKrSMPAlCs9vbpCPq0Uk/Untitled?node-id=1-10&node-type=canvas
</div>
<br>
<div>Figma를 사용해 실제로 구현할 기능들을 선별하였습니다. 불필요한 기능들은 제거하고 필수적인 기능들만 남겨 UI 화면 구성을 진행했습니다. </div>
<br>
<div>
  <img width="432" alt="화면 캡처 2024-09-10 222255" src="https://github.com/user-attachments/assets/9c3efa4c-2ae5-45b5-b76d-d55b316ab65d">
  <img width="428" alt="화면 캡처 2024-09-10 222312" src="https://github.com/user-attachments/assets/f600ba5d-41a2-4b38-9fb6-5b40845d5c9d">
  <img width="430" alt="화면 캡처 2024-09-10 222401" src="https://github.com/user-attachments/assets/a8e30508-2b06-4cda-bace-ce63055e2b62">
  <img width="425" alt="화면 캡처 2024-09-10 222413" src="https://github.com/user-attachments/assets/4dbc4c04-856a-4ef0-802a-6e6f54485ef1">
</div>

<h1>3. DB 설계 </h1>
https://docs.google.com/spreadsheets/d/1Dme_0goq8qt7FFXQe4bDaYsR6-dDV3rv8gpoxJ6ijHA/edit?usp=sharing

<div> 필수 테이블들을 미리 기획하고 설계까지 진행하였습니다. NULL 값 가능 여부를 적고 컬럼 타입도 미리 정했습니다. DB기획서를 바탕으로 쉽게 mysql 테이블 설계를 할 수 있었습니다 </div>
<br>
<img width="806" alt="화면 캡처 2024-09-10 222934" src="https://github.com/user-attachments/assets/f72f287b-e7cc-4727-8e28-6c020d0bc137">
<img width="767" alt="화면 캡처 2024-09-10 223526" src="https://github.com/user-attachments/assets/7189c33f-0768-4633-9f8f-c17929c0cf27">
<img width="809" alt="화면 캡처 2024-09-10 223515" src="https://github.com/user-attachments/assets/1f95e3ca-711a-48f1-93b8-871a2bc249f7">

<h1>4. url 설계 </h1>
https://docs.google.com/spreadsheets/d/1Dme_0goq8qt7FFXQe4bDaYsR6-dDV3rv8gpoxJ6ijHA/edit?usp=sharing
<div>백엔드 경로 매핑을 하다보면, 이름을 중복해서 짓는 경우로 많고 경로가 헷갈릴 때도 많습니다. 그 혼란을 미리 방지하기 위해 url 설계도 미리 진행해줍니다.
파라미터값과 응답값도 고정해줍니다</div>
<br>
<img width="797" alt="화면 캡처 2024-09-10 223909" src="https://github.com/user-attachments/assets/1bee1589-4e1e-4e85-ab2f-9ca281233020">
<img width="794" alt="화면 캡처 2024-09-10 223930" src="https://github.com/user-attachments/assets/6cce35b0-2598-43b1-a552-518b75695eec">

<h1>5. 일정표 </h1>
https://docs.google.com/spreadsheets/d/1QJVjdZvttGgFFo3KqmKOFznd6J5evbU15bOu7DIunmo/edit?gid=0#gid=0
<br>

<div> 필수 구현요소들을 정리해서 계획일정표를 작성했습니다. 회원가입, 로그인 타임라인과 프로필, 팔로잉, 팔로우를 중심으로 계획서를 날짜별로 계획했습니다 </div>

<img width="1068" alt="화면 캡처 2024-09-10 224443" src="https://github.com/user-attachments/assets/e080cc53-e841-42e3-8aa1-33d4fe76e4cf">

<h1>6. 개발 시작</h1>
소스트리를 이용해 깃허브 원격저장소를 설정해주고 자바 spring 세팅도 진행했습니다.

<h1>7. 결과 </h1>
<span>로그인, 회원가입 페이지 구현</span>
<div> 회원가입시 비밀번호가 없으면 비밀번호 출력</div>
<img width="836" alt="화면 캡처 2024-09-10 224849" src="https://github.com/user-attachments/assets/488385d5-8146-434a-9c80-9012694fa500">
<img width="826" alt="화면 캡처 2024-09-10 224753" src="https://github.com/user-attachments/assets/63cd913f-3c08-435c-8c87-0938f182661d">
<img width="839" alt="화면 캡처 2024-09-10 224732" src="https://github.com/user-attachments/assets/0229ab08-97c4-4e76-85ce-d9b2b36b1107">
<img width="340" alt="화면 캡처 2024-09-10 224903" src="https://github.com/user-attachments/assets/4625ec60-f543-434f-b5b8-ca8701bb74b5">
<img width="332" alt="화면 캡처 2024-09-10 224923" src="https://github.com/user-attachments/assets/b2587883-0103-4ab8-aaab-77cd893816e7">



