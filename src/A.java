/*
@SuppressWarnings("rawtypes")
private static final class ByIdsSpecification<T> implements Specification<T> {

    private static final long serialVersionUID = 1L;

    private final JpaEntityInformation<T, ?> entityInformation;

    @Nullable ParameterExpression<Collection<?>> parameter;

    ByIdsSpecification(JpaEntityInformation<T, ?> entityInformation) {
        this.entityInformation = entityInformation;
    }

    */
/*
 * (non-Javadoc)
 * @see org.springframework.data.jpa.domain.Specification#toPredicate(javax.persistence.criteria.Root, javax.persistence.criteria.CriteriaQuery, javax.persistence.criteria.CriteriaBuilder)
 *//*

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        Path<?> path = root.get(entityInformation.getIdAttribute());
        parameter = (ParameterExpression<Collection<?>>) (ParameterExpression) cb.parameter(Collection.class);
        return path.in(parameter);
    }
}
*/
public class A {

    Object

    static int aStaticField;

    GenericType1<GenericType2<?>> genVar2;

    static String a(String text) {
        return text + " de A";
    }

    void b() {
        GenericType1<GenericType2> genVar = new GenericType1<GenericType2>() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };
        // GenericType1<GenericType2<?>> genVar1 = (GenericType1<GenericType2<?>>) genVar;
        genVar2 = (GenericType1<GenericType2<?>>) (GenericType1) genVar;

    }
}

interface TypeTest {

}

interface GenericType1<T> {

}

interface GenericType2<T> {

}

class TypeTestImpl implements TypeTest {

}

class GenericType1Impl<T> implements GenericType1<T> {

}

class GenericType2Impl<T> implements GenericType2<T> {

}
