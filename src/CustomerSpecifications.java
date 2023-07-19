public class CustomerSpecifications {

    /*public static Specification<Customer> customerHasBirthday() {
        return new Specification<Customer> {
            public Predicate toPredicate (Root < T > root, CriteriaQuery query, CriteriaBuilder cb){
                return cb.equal(root.get(Customer_.birthday), today);
            }
        } ;
    }

    public static Specification<Customer> isLongTermCustomer() {
        return new Specification<Customer> {
            public Predicate toPredicate (Root < T > root, CriteriaQuery query, CriteriaBuilder cb){
                return cb.lessThan(root.get(Customer_.createdAt), new LocalDate.minusYears(2));
            }
        } ;
    }*/
}
