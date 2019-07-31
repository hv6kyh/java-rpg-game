## 프로젝트명
The World  
(팀 프로젝트 : 코딩 부분 전적으로 담당)
## 사용언어
JAVA
## 개발기간
2016.08~2016.11
## 프로젝트 소개
JAVA 언어를 이용한 RPG 게임
스윙 컴포넌트를 이용해 GUI 구현
*****
## 실행화면
이미지를 클릭하면 비디오 재생

[![Video Label](http://img.youtube.com/vi/EoAe26bLDQ0/0.jpg)](https://youtu.be/EoAe26bLDQ0?t=0s)  


[![Video Label](http://img.youtube.com/vi/W-_PS2y2YEE/0.jpg)](https://youtu.be/W-_PS2y2YEE?t=0s)  
*****
모든 맵은 각각 하나의 Panel로 구현됨.  

AfricaDungeon1.java  (AfricaDungeon1은 Map을 상속받음.)
```JAVA
@Override
public boolean reachPortal() {
  // TODO Auto-generated method stub
  boolean b = false;

  if (
      playerCharactor.getVpz().equals(new Point(1, 6))
      || playerCharactor.getVpz().equals(new Point(1, 7))
      || playerCharactor.getVpz().equals(new Point(1, 8))
      || playerCharactor.getVpz().equals(new Point(1, 9))

    )
  {
//			SoundEngine.stopBGMSound();
    nextPanel = new AfricaDungeon2();
    b = true;
    playerCharactor.setP(new Point(23*Map.getTileSize().width,7*Map.getTileSize().height));
  }

  return b;
}
```
AfricaDungeon1에 있는 포탈에 도착한 경우, AfricaDungeon2로 이동.  


Map.java
```JAVA
if (reachPortal() == true) {
  MainFrame.setCurrentPanel(nextPanel);
}
```
메인 프레임의 setCurrentPanel() 메소드를 호출하여 알맞는 패널로 교체한다.  


Map.java
```JAVA
protected PlayerCharactor playerCharactor = PlayerCharactor.getInstance();
```
사용자 캐릭터는 싱글톤패턴으로 제작.  
객체를 한번 생성하고, 그 이후 생성된 인스턴스를 사용한다.  
개념상 단 한 명이어야 하는 사용자 캐릭터의 특성상, 불필요한 충돌을 없앤다.
