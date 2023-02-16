package pl.coderslab.repository.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.TransactionDao;
import pl.coderslab.encje.Transaction;
import pl.coderslab.repository.ClientRepository;
import pl.coderslab.repository.TransactionRepository;

import java.sql.Timestamp;
import java.util.Date;

@Service
@Primary
@RequiredArgsConstructor
public class TransactionServiceJPA implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionDao transactionDao;
    private final ClientRepository clientRepository;

    public Timestamp getDate() {
        Date date= new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        return ts;
    }
    @Override
    public int transfer(String source,String dest,Long amount)
    {
        Timestamp timestamp=getDate();
        return transfers(source,dest,timestamp,amount);
    }

    public int transfers(String source, String dest, Timestamp date, Long amount) {
        System.out.println("--"+source+"--"+dest+"--"+date+"--"+amount+"--");
        Transaction transaction = new Transaction(source,dest,date, Math.toIntExact(amount));
        transactionDao.save(transaction);
        Long samt=clientRepository.getBalanceByUserEmail(source);
        Long damt=clientRepository.getBalanceByUserEmail(dest);
        if(samt-amount>0) {
            samt-=amount;
            damt+=amount;
        }
        else return 0;
        System.out.println("--"+source+"--"+dest+"--"+date+"--"+amount+"--");
        clientRepository.setClientBalance(samt, source);
        System.out.println("##source##"+source+"#dest#"+dest+"--"+date+"--"+amount+"--yes");
        clientRepository.setClientBalance(damt, dest);
        return 1;
    }


}
