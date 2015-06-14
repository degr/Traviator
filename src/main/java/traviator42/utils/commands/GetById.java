package traviator42.utils.commands;

import org.openqa.selenium.WebElement;
import traviator42.utils.WD;

/**
 * Created by Ror on 10.06.2015.
 */
public class GetById extends AbstractCommand {

    @Override
    public String execute(WD d, String... args) {
        this.d = d;
        String out = "";
        if(args.length > 0) {

            WebElement el = d.id(args[0]);

        }
        return null;
    }
}
