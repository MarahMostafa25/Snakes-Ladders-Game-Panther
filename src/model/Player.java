package model;

public class Player {
	private String nickName;
	private int Xposition;
	private int Yposition;
	private String AvatarPath;

	public Player(String nickName, int Xposition, int Yposition, String AvatarPath) {
		this.nickName = nickName;
		this.Xposition = Xposition;
		this.Yposition = Yposition;
		this.AvatarPath = AvatarPath;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getXposition() {
		return Xposition;
	}

	public void setXposition(int xposition) {
		Xposition = xposition;
	}

	public int getYposition() {
		return Yposition;
	}

	public void setYposition(int yposition) {
		Yposition = yposition;
	}

	public String getAvatarPath() {
		return AvatarPath;
	}

	public void setAvatarPath(String avatarPath) {
		AvatarPath = avatarPath;
	}

	@Override
	public String toString() {
		return "player [nickName=" + nickName + ", Xposition=" + Xposition + ", Yposition=" + Yposition
				+ ", AvatarPath=" + AvatarPath + "]";
	}
}