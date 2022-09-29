package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.rest.entity.Event;
import se331.rest.entity.Organizer;
import se331.rest.repository.EventRepository;
import se331.rest.repository.OrganizerRepository;
import se331.rest.entity.Participant;
import se331.rest.repository.ParticipantRepository;
import javax.transaction.Transactional;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    OrganizerRepository organizerRepository;

    @Autowired
    ParticipantRepository participantRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1,org2,org3;
        Participant participant1, participant2, participant3, participant4, participant5;
        org1 = organizerRepository.save(Organizer.builder().name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder().name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder().name("ChiangMai").build());
        participant1 = participantRepository.save(Participant.builder()
                .telNo("505-367-9585")
                .name("Tristram Madhav").build());
        participant2 = participantRepository.save(Participant.builder()
                .telNo("863-514-4833")
                .name("Hemming Catrin").build());
        participant3 = participantRepository.save(Participant.builder()
                .telNo("304-837-2583")
                .name("Hammurabi Adelaida").build());
        participant4 = participantRepository.save(Participant.builder()
                .telNo("317-437-1540")
                .name("Tiitus Gerolt").build());
        participant5 = participantRepository.save(Participant.builder()
                .telNo("410-472-9303")
                .name("Annabeth Vratislav").build());
        Event tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        participant1.getEventHistory().add(tempEvent);
        participant2.getEventHistory().add(tempEvent);
        participant3.getEventHistory().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        participant1.getEventHistory().add(tempEvent);
        participant2.getEventHistory().add(tempEvent);
        participant3.getEventHistory().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tempEvent);
        participant1.getEventHistory().add(tempEvent);
        participant2.getEventHistory().add(tempEvent);
        participant3.getEventHistory().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .build());
        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);
        participant4.getEventHistory().add(tempEvent);
        participant5.getEventHistory().add(tempEvent);
    }
}
