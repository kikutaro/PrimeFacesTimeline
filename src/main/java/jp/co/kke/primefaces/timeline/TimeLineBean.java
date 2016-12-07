package jp.co.kke.primefaces.timeline;

import java.io.Serializable;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.timeline.TimelineEvent;
import org.primefaces.model.timeline.TimelineModel;

/**
 * TimeLineBean.
 * 
 * PrimeFacesのTimeLineコンポーネントで1年を振り返る。
 * 
 * @author kikuta
 */
@Named(value = "timeLineBean")
@ViewScoped
public class TimeLineBean implements Serializable {

    @Getter @Setter
    private TimelineModel tl;
    
    @PostConstruct
    public void init() {
        tl = new TimelineModel();
        
        Calendar calFrom = Calendar.getInstance();
        Calendar calTo = Calendar.getInstance();
        calFrom.set(2015, Calendar.AUGUST, 15);
        calTo.set(2016, Calendar.AUGUST, 31);
        tl.add(new TimelineEvent("常駐", calFrom.getTime(), calTo.getTime()));
        calFrom.set(2016, Calendar.SEPTEMBER, 1);
        calTo.set(2016, Calendar.SEPTEMBER, 30);
        tl.add(new TimelineEvent("異動・引継", calFrom.getTime(), calTo.getTime()));
        calFrom.set(2016, Calendar.OCTOBER, 1);
        calTo.set(2016, Calendar.OCTOBER, 1);
        tl.add(new TimelineEvent("人間", calFrom.getTime(), Calendar.getInstance().getTime()));
    }
    
}
