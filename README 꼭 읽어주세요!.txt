
안녕하세요 이번에 백엔드 지원한 HR팀 SAUL입니다.

축제준비와 밀린 과제 및 퀴즈 등으로 밀리고 컴퓨터 설정오류가 풀리지 않아.. 과제를 완벽하게 하지 못했습니다.
과제의 시간이 더 있었으면 좋았겠지만 시간이 많이 남지않아 어떻게 코드를 설계해서 진행할것이였는지
설명을 담은 파일입니다.

패키지는 Controller, Service, Repository로 단계적으로 진행을 하며, REST api를 이용하여 만들예정이였
습니다. JSON으로 입출력을 내보냅니다.


1번 회원가입

회원가입의 request를 받으면 @PostMapping을 Controller에서 dto로 받아 서비스로 넘겨줍니다.
서비스의 create fun으로 dto를 Entity로 변경하고 CrudRepository의 save를 이용하여 저장합니다.
저장된 Entity를 password를 제거한후 ResponseEntity의 body에 담아 JSON으로 내보냅니다.


2. 게시글 작성
회원가입에서 사용한 SignInRepository와 게시글에서 사용할 ArticleRepository 두개를 이용하여
구현합니다. 한 아이디에서 여러 게시글을 작성할 수 있으므로 @ManyToOne, @JoinColumn을 이용해서 
구현합니다.
들어온 email값과 비밀번호 값을 findbyid를 이용해서 저장된 비밀번호와 대조한후 진행합니다.
title과 content를 array형태로 불러 "" , " " 가 들어있는지 확인합니다. null은 처음 entity지정할때
허용하지 않기때문에 pass합니다.
이후 위와 같은 방식으로 저장합니다.


3. 게시글 수정
Dto->Entity, DB에서 기존 데이터 갖고오고 값을 갱신 
비밀번호 대조 후 email값이 같은 findby를 이용하여 같은 email로 작성된 게시글 리스트를 받아오고
리스폰스 합니다.


4. 댓글작성하기
댓글 작성하기는 email->article->comment순서로 @ManyToOne 방식이 진행되고 하나의 아이디에서 
여러 게시글이 작성되는것 처럼 하나의 article에서 여러 comment들이 작성된다고 생각했습니다.


5. 댓글수정
Dto->Entity, DB에서 기존 데이터 갖고오고 값을 갱신
동일 email로 작성된 댓글들을 findby로 찾아온 후 댓글 entity를 commentid 포함해서 리스폰스

6. 댓글삭제
@PostMapping("/api/articles/{id}")
으로 id 값을 @PathVariable로 받아 특정 댓글을 삭제합니다. 
findbyid로 삭제 대상을 찾고 CrudRepo .delete이용 해서 삭제

7.회원탈퇴
같은 email로 작성된 게시글, 댓글들을 findby로 찾은 후 delete 한다.



----------------------------------------------------------------------------------------------------------
Ace님과 코틀린을 같이 진행했지만 어떤 프로젝트를 만들어보는건 처음이였습니다. 위에 적은 방법이
다틀릴수도 있지만 제가 아는것에한하여 적어보았습니다. 열심히 해보려고 했지만 spring boot를 DB에
적용하는것에 너무 많은 오류가 뜨고 해결하는데 시간이 너무 많이 소비가 되었네요....

이번 리크루팅에 정말 많은 지원자들이 지원해주셨고 좋은 인재분들이 많을것으로 기대됩니다. HR리더로
서 정말 좋게 생각합니다! 과제를 완벽하게 해내지 못했기 때문에 기대는 안하고 있습니다.
합격은 하지 못하더라고 혹시 인큐베이팅에 청강 or 참가 형식으로 참여가 가능한지 여쭈어봅니다.
slack 답장 기다리겠습니다! 감사합니다.










