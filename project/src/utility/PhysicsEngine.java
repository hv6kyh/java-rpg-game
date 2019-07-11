package utility;

import charactors.Monster;
import charactors.PlayerCharactor;

public class PhysicsEngine {
	
	// 방송하기
	// 플레이어의 위치는 모든 맵에서 공유되어야 한다.
	// 몬스터는 플레이어가 자신의 범위에 속하는지 판별한다
	// 그 몬스터만 공격자의 범위에 있는지 판별한다
	// 자신의 범위에 공격자가 속하는 몬스터는 공유되어야 한다
	// 공유되어야 하는 컴포넌트 : 플레이어, 인접한 몬스터
	// 몬스터는 리스트에 담는다

	private static PlayerCharactor player = PlayerCharactor.getInstance();

	public static void hit(Monster monster) {

		if (player.getRange().contains(monster.getCenterPosition())) {
			
			monster.attacked(player.getStat().getAtk(), player.getOldMove());
			
		}

	}

}
