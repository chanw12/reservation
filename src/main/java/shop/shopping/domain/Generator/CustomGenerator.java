package shop.shopping.domain.Generator;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;
import java.util.stream.Stream;

public class CustomGenerator implements IdentifierGenerator {
    private String prefix;

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        prefix = params.getProperty("prefix");
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        String query = String.format("select %s from %s",
                session.getEntityPersister(obj.getClass().getName(), obj)
                        .getIdentifierPropertyName(),
                obj.getClass().getSimpleName());

        Stream ids = session.createQuery(query,String.class).stream();

        Long max = ids.map(o ->  o.toString().replace(prefix + "_", ""))
                .mapToLong(str -> {
                    try {
                        return Long.parseLong(str.toString());
                    }catch(NumberFormatException ex){
                        return 0L;
                    }
                })
                .max()
                .orElse(0L);

        return prefix + "_" + (max + 1);
    }
}
