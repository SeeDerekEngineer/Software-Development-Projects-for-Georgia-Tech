Since the software will only be keeping track of purchases made by VIP customers, non-registered customers will not be 
included in the program design.

Each order and pre-order includes the price, the calculated points the customer will receive (since fractions of dollars
are excluded), as well as the calculated cost and points awarded were the customer GOLD status VIP customer.  The date
is included for purposes of determining monthly purchases and points.

For pre-orders, the date of pickup is also included and a subsequent boolean attribute 'pickUpDateAvailable' is used to 
verify if that date has available slots for a pickup.  The requirement that the pre-order may be no farther than a week 
in advance is assumed to be inherent in the calculated boolean attribute as well.

VIPCustomer includes calculated attributes.  
