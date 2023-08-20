package ma.theatre.theatremanagementsystembackend.mappers;

import ma.theatre.theatremanagementsystembackend.dtos.TicketDTO;
import ma.theatre.theatremanagementsystembackend.entities.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketDTO map(Ticket ticket);
    Ticket map(TicketDTO ticketDTO);

//    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);
//
//    @Mapping(source = "ticketId", target = "ticketId")
//    @Mapping(source = "CustomerName", target = "CustomerName")
//    @Mapping(source = "price", target = "price")
//    @Mapping(source = "paymentCode", target = "paymentCode")
//    @Mapping(source = "reserved", target = "reserved")
//    TicketDTO ticketToTicketDTO(Ticket ticket);
}
