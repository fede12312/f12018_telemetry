package packets;

import packets.carmotion.PacketMotionData;
import packets.carstatus.PacketCarStatusData;
import packets.cartelemetry.PacketCarTelemetryData;
import packets.carsetup.PacketCarSetupData;
import packets.participants.PacketParticipantsData;
import packets.event.PacketEventData;
import packets.lapdata.PacketLapData;
import packets.session.PacketSessionData;

/**
 * Class to build the appropiate packet base on its ID.
 * @author miguelangel.garciar
 */
public class PacketFactory {
    
    /**
     * Return a new packet with all its data in function of its ID.
     * @param content All datagram byte content.
     * @return 
     */
    public static Packet getPacket(byte[] content){
        Packet p = new Packet(content);
        switch(p.packetId){
            case 0: return new PacketMotionData(content);
            case 1: return new PacketSessionData(content);
            case 2: return new PacketLapData(content);
            case 3: return new PacketEventData(content);
            case 4: return new PacketParticipantsData(content);
            case 5: return new PacketCarSetupData(content);
            case 6: return new PacketCarTelemetryData(content);
            case 7: return new PacketCarStatusData(content);
            default: return null;
        }
    }
    
}
