package model;

public class Player {
	private int PlayerId;
	private String nickName;
	private int position;
	private String AvatarPath;
	private int score;
	private static int id=0;

	public Player(String nickName, int position, String AvatarPath) {
		this.PlayerId=id++;
		this.nickName = nickName;
		this.position = position;
		this.AvatarPath = AvatarPath;
	}

	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}
	
	


	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getAvatarPath() {
		return AvatarPath;
	}

	public void setAvatarPath(String avatarPath) {
		AvatarPath = avatarPath;
	}

	@Override
	public String toString() {
		return "player [nickName=" + nickName + ", position=" + position 
				+ ", AvatarPath=" + AvatarPath + "]";
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Player.id = id;
	}

	public int getPlayerId() {
		return PlayerId;
	}

	public void setPlayerId(int playerId) {
		PlayerId = playerId;
	}
	
	

	
	
}