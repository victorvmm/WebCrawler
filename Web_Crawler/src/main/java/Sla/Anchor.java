package Sla;

import java.sql.Timestamp;

public class Anchor {
    private final Domain domain;
    private final String anchorHash;
    private final String anchorUrl;
    private int scanStatus;
    private boolean activated;
    private Timestamp modified;
    private  Timestamp created;

    public Domain getDomain() {
        return domain;
    }

    public String getAnchorHash() {
        return anchorHash;
    }

    public String getAnchorUrl() {
        return anchorUrl;
    }

    public int getScanStatus() {
        return scanStatus;
    }

    public boolean isActivated() {
        return activated;
    }

    public Timestamp getModified() {
        return modified;
    }

    public Timestamp getCreated() {
        return created;
    }

    public Anchor(String anchorHash, String anchorUrl, Domain domain) {
        this.anchorHash = anchorHash;
        this.anchorUrl = anchorUrl;
        this.domain = domain;
    }

    public Anchor(Domain domain, String anchorHash, String anchorUrl, int scanStatus, boolean activated, Timestamp modified, Timestamp created) {
        this.domain = domain;
        this.anchorHash = anchorHash;
        this.anchorUrl = anchorUrl;
        this.scanStatus = scanStatus;
        this.activated = activated;
        this.modified = modified;
        this.created = created;
    }
}
