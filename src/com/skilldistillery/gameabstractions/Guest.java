package com.skilldistillery.gameabstractions;

public class Guest {
	
	private static int nextGuestID = 42;
	private String username;
	private int guestID;
	
	{
		guestID = nextGuestID++;
	}
	
	public Guest() {
		username = "BellagioGuest" + guestID;
	}
	
	public Guest(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	@Override
	public int hashCode() {
		return guestID;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guest other = (Guest) obj;
		return guestID == other.guestID;
	}
}
