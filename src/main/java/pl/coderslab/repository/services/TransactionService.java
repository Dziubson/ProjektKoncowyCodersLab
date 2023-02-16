package pl.coderslab.repository.services;

public interface TransactionService {
    int transfer(String source,String dest,Long amount);

}
