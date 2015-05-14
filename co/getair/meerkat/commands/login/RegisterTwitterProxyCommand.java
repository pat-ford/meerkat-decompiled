package co.getair.meerkat.commands.login;

import co.getair.meerkat.proxies.TwitterProxy;
import org.puremvc.java.multicore.interfaces.INotification;
import org.puremvc.java.multicore.patterns.command.SimpleCommand;
import org.puremvc.java.multicore.patterns.facade.Facade;

public class RegisterTwitterProxyCommand extends SimpleCommand
{
  public void execute(INotification paramINotification)
  {
    super.execute(paramINotification);
    TwitterProxy localTwitterProxy = new TwitterProxy("twitterProxy", null);
    getFacade().registerProxy(localTwitterProxy);
  }
}