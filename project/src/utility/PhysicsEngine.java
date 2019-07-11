package utility;

import charactors.Monster;
import charactors.PlayerCharactor;

public class PhysicsEngine {
	
	// ����ϱ�
	// �÷��̾��� ��ġ�� ��� �ʿ��� �����Ǿ�� �Ѵ�.
	// ���ʹ� �÷��̾ �ڽ��� ������ ���ϴ��� �Ǻ��Ѵ�
	// �� ���͸� �������� ������ �ִ��� �Ǻ��Ѵ�
	// �ڽ��� ������ �����ڰ� ���ϴ� ���ʹ� �����Ǿ�� �Ѵ�
	// �����Ǿ�� �ϴ� ������Ʈ : �÷��̾�, ������ ����
	// ���ʹ� ����Ʈ�� ��´�

	private static PlayerCharactor player = PlayerCharactor.getInstance();

	public static void hit(Monster monster) {

		if (player.getRange().contains(monster.getCenterPosition())) {
			
			monster.attacked(player.getStat().getAtk(), player.getOldMove());
			
		}

	}

}
