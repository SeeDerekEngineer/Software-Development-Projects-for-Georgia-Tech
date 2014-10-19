Since the software will only be keeping track of purchases made by VIP customers, non-registered customers will not be 
included in the program design.

Each order and pre-order includes the price, the calculated points the customer will receive (since fractions of dollars
are excluded), as well as the calculated cost and points awarded were the customer GOLD status VIP customer.  The date
is included for purposes of determining monthly purchases and points.

For pre-orders, the date of pickup is also included and a subsequent boolean attribute 'pickUpDateAvailable' is used to 
verify if that date has available slots for a pickup.  The requirement that the pre-order may be no farther than a week 
in advance is assumed to be inherent in the calculated boolean attribute as well.

VIPCustomer includes calculated attributes.  Specifically, from the VIP Points calculated in total and per month, the candidacy for GOLD status and the qualification for the free item per month are determined.  These will then be used in the order or pre-order methods to provide the customer with their benefits. 

VIPCustomer includes the 'getPurchases' and 'getPoints' operations which will provide both the total purchases/points and the purchases/points accrued since the start of their VIP membership.  Since transactions from customers prior to VIP membership are not recorded, it is assumed that the customer's purchases prior to becoming a VIP member, if any, are not considered in calculating points/purchases.

It is assumed a 'main' method will be included in the software's implementation, so it was excluded from the UML Class Diagram for purposes of conciseness.

The multiplicities for both the "Order" and "Pre-Order" associations should read '*' to signify the multiple possible components from each end of the associations.  For some reason ArgoUML would not enable custom multiplities and by default entered '1' when a star was entered.
