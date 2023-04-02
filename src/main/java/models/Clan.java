package models;

public class Clan {

    private int badgeId;
    private String tag;
    private String name;

    public Clan(int badgeId, String tag, String name) {
        this.badgeId = badgeId;
        this.tag = tag;
        this.name = name;
    }

    //accessors

    public int getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(int badgeId) {
        this.badgeId = badgeId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
