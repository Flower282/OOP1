package aims.media.sort;
import java.util.Comparator;
import aims.media.Media;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        return Comparator.comparing(Media::getCost)
                .thenComparing(Media::getTitle)
                .compare(m1, m2);
    }
    
}