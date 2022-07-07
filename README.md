# EntitySteerAPI
#### Event API for Steering Entity

![GIF 2022-07-07 오후 5-12-45](https://user-images.githubusercontent.com/61282478/177725117-79deb7d9-6b28-4c20-861f-6c48a16a68bf.gif)

단순한 API 플러그인입니다. 서버에 위 플러그인을 직접 적용하시는것 보단 수정하셔서 사용하시는걸 추천 드립니다.


· Event API
<br/>  · EntitySteerEvent: 엔티티에 탑승한경우 WASD, 스페이스, 쉬프트등을 인식할 수 있는 이벤트입니다.
<br/>      Direction [ENUM] : 방향 데이터 열거형입니다. UP,DOWN,RIGHT,LEFT,JUMP,UNMOUNT등이 있습니다.
<br/>        boolean isForward() : W키를 눌렀는지 여부를 반환합니다.
<br/>        boolean isBackward() : S키를 눌렀는지 여부를 반환합니다.
<br/>        boolean isRight() : D키를 눌렀는지 여부를 반환합니다.
<br/>        boolean isLeft() : A키를 눌렀는지 여부를 반환합니다.
<br/>        boolean isJump() : 스페이스바를 눌렀는지 여부를 반환합니다. 
<br/>        boolean isUnmount() : 쉬프트키를 눌렀는지 여부를 반환합니다.
<br/>        Player getWhoSteer() : 조종하는 플레이어를 반환합니다.
<br/>        Entity getEntity() : 플레이어가 조종하는 엔티티를 반환합니다.

· 주의점 : 위 이벤트는 '엔티티에 탑승한 직후'부터 아무키를 누르지 않아도 지속적으로 호출됩니다. 사용하실땐 위 소스코드를 키 데이터가 포함된경우 이벤트가 호출되게 수정한뒤 사용하는게 좋을것 같습니다.

