package com.mosfeq.selfdevelopmentapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.quotes_fragment.*

class QuotesFragment: Fragment(R.layout.quotes_fragment) {

    private val quotesList = arrayListOf<QuoteItem>()
    private val adapter = QuoteAdapter(quotesList)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        quotes_recycler_view.adapter = adapter
        quotes_recycler_view.layoutManager = LinearLayoutManager(context)
        quotes_recycler_view.setHasFixedSize(true)

        val quoteItem1 = QuoteItem(
            "Even if we don't have the power to choose where we come from, we can still choose where we go from there.",
            "Stephen Chbosky")
        quotesList+= quoteItem1
        adapter.notifyItemInserted(0)

        val quoteItem2 = QuoteItem(
            "TRANSFORMATION is much more than using skills, resources and technology. It’s all about HABITS of mind.",
            "Malcolm Gladwell")
        quotesList+= quoteItem2
        adapter.notifyItemInserted(0)

        val quoteItem3 = QuoteItem(
            "Everything is hard before it is easy.",
            "Johann Wolfgang von Goethe")
        quotesList+= quoteItem3
        adapter.notifyItemInserted(0)

        val quoteItem4 = QuoteItem(
            "You cannot change your future; but, you can change your habits, and surely your habits…will change your future.",
            "Dr. Abdul Kalam")
        quotesList+= quoteItem4
        adapter.notifyItemInserted(0)

        val quoteItem5 = QuoteItem(
            "Nothing happens until the pain of remaining the same outweighs the pain of change.",
            "Arthur Burt")
        quotesList+= quoteItem5
        adapter.notifyItemInserted(0)

        val quoteItem6 = QuoteItem(
            "Depending on what they are, our habits will either make us or break us. We become what we repeatedly do.",
            "Sean Covey")
        quotesList+= quoteItem6
        adapter.notifyItemInserted(0)

        val quoteItem7 = QuoteItem(
            "Good habits are worth being fanatical about.",
            "John Irving")
        quotesList+= quoteItem7
        adapter.notifyItemInserted(0)

        val quoteItem8 = QuoteItem(
            "You leave old habits behind by starting out with the thought, ‘I release the need for this in my life.’",
            "Wayne Dyer")
        quotesList+= quoteItem8
        adapter.notifyItemInserted(0)

        val quoteItem10 = QuoteItem(
            "Habits are safer than rules; you don’t have to watch them. And you don’t have to keep them either. They keep you.",
            "Frank Hall Crane")
        quotesList+= quoteItem10
        adapter.notifyItemInserted(0)

        val quoteItem11 = QuoteItem(
            "If you are going to achieve excellence in big things, you develop the habit in little matters. Excellence is not an exception, it is a prevailing attitude.",
            "Colin Powell")
        quotesList+= quoteItem11
        adapter.notifyItemInserted(0)

        val quoteItem12 = QuoteItem(
            "When you fall in love with the process rather than the product, you don’t have to wait to give yourself permission to be happy. You can be satisfied anytime your system is running.",
            "James Clear")
        quotesList+= quoteItem12
        adapter.notifyItemInserted(0)

        val quoteItem13 = QuoteItem(
            "The chains of habit are too weak to be felt until they are too strong to be broken.",
            "Samuel Johnson")
        quotesList+= quoteItem13
        adapter.notifyItemInserted(0)

        val quoteItem14 = QuoteItem(
            "Successful people aren’t born that way. They become successful by establishing the habit of doing things unsuccessful people don’t like to do.",
            "William Makepeace Thackeray")
        quotesList+= quoteItem14
        adapter.notifyItemInserted(0)

        val quoteItem15 = QuoteItem(
            "Excellence is an art won by training and habituation.",
            "Aristotle")
        quotesList+= quoteItem15
        adapter.notifyItemInserted(0)

        val quoteItem16 = QuoteItem(
            "You’ll never change your life until you change something you do daily. The secret of your success is found in your daily routine.",
            "John C. Maxwell")
        quotesList+= quoteItem16
        adapter.notifyItemInserted(0)

        val quoteItem17 = QuoteItem(
            "The secret to permanently breaking any bad habit is to love something greater than the habit.",
            "Bryant McGill")
        quotesList+= quoteItem17
        adapter.notifyItemInserted(0)

        val quoteItem18 = QuoteItem(
            "You should be far more concerned with your current trajectory than with your current results.",
            "James Clear")
        quotesList+= quoteItem18
        adapter.notifyItemInserted(0)

        val quoteItem19 = QuoteItem(
            "Habit is a cable; we weave a thread each day, and at last we cannot break it.",
            "Horace Mann")
        quotesList+= quoteItem19
        adapter.notifyItemInserted(0)

        val quoteItem20 = QuoteItem(
            "Feeling sorry for yourself, and your present condition is not only a waste of energy but the worst habit you could possibly have.",
            "Dale Carnegie")
        quotesList+= quoteItem20
        adapter.notifyItemInserted(0)
    }

}