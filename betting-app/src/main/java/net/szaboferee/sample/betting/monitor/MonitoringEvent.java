package net.szaboferee.sample.betting.monitor;

public class MonitoringEvent {
    private final Integer id;
    private final String event;
    private Long timestamp;

    public MonitoringEvent(Integer id, String event, Long timestamp) {
        this.id = id;
        this.event = event;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public String getEvent() {
        return event;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
