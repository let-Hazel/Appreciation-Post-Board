package co.wethinkcode.shoutout.listener;

import co.wethinkcode.shoutout.model.Shoutout;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ShoutoutModeratorListener {

    @JmsListener(destination = "school-shoutouts-queue")
    public void processShoutout(Shoutout shoutout) {
        // Basic moderation rule: replace bad words
        String cleanMessage = shoutout.getMessage()
                .replaceAll("(?i)slacker", "***")
                .replaceAll("(?i)hate", "***");

        // Format output for live display
        // ANSI Color Codes for terminal styling
        String RESET  = "\u001B[0m";
        String BOLD   = "\u001B[1m";
        String CYAN   = "\u001B[36m";
        String GREEN  = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String MAGENTA= "\u001B[35m";
        String BLUE   = "\u001B[34m";

        System.out.println(CYAN + "✨" + MAGENTA + "━━━━━━━" + YELLOW + "━━━━━━━" + GREEN + "━━━━━━━" + BLUE + "━━━━━━━" + MAGENTA + "━━━━━━━" + CYAN + "✨" + RESET);
        System.out.println(BOLD + GREEN + "  :) NEW APPRECIATION POST APPROVED!   " + RESET);
        System.out.println(CYAN + "✨" + MAGENTA + "━━━━━━━" + YELLOW + "━━━━━━━" + GREEN + "━━━━━━━" + BLUE + "━━━━━━━" + MAGENTA + "━━━━━━━" + CYAN + "✨" + RESET);
        
        System.out.println(BOLD + MAGENTA + "TO       : " + RESET + BOLD + shoutout.getRecipient() + RESET + YELLOW + RESET);
        System.out.println(BOLD + BLUE    + "FROM     : " + RESET + shoutout.getSender());
        System.out.println(BOLD + GREEN   + "MESSAGE  : " + RESET + "“" + cleanMessage + "”");
        
        System.out.println(CYAN + "-------------------------------------------" + RESET);
        System.out.println(YELLOW + "Impact   : Spread kindness around campus!" + RESET);
        System.out.println(MAGENTA + "Status   : Processed & Published via JMS" + RESET);
        System.out.println(CYAN + "✨" + MAGENTA + "━━━━━━━" + YELLOW + "━━━━━━━" + GREEN + "━━━━━━━" + BLUE + "━━━━━━━" + MAGENTA + "━━━━━━━" + CYAN + "✨\n" + RESET);
    }
}